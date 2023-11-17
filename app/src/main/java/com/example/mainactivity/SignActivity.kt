package com.example.mainactivity


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.example.mainactivity.databinding.ActivitySignBinding
import com.google.firebase.firestore.FirebaseFirestore


import java.util.*

private lateinit var btn_submit:ImageButton
private lateinit var btn_date:ImageButton
//private lateinit var sex:RadioGroup
private lateinit var account:TextView
private lateinit var password:TextView
private lateinit var check_pwd:TextView
private lateinit var name:TextView
private lateinit var age:TextView
private lateinit var gender:TextView
private lateinit var eye:ImageView
private lateinit var checkeye:ImageView
private lateinit var userid:TextView

const val TAG="FIRESTORE"
class SignActivity : AppCompatActivity() {
    private  var binding:ActivitySignBinding? =null
    val fireStoreDatabase= FirebaseFirestore.getInstance()

    private var currentUserId = 0
    private fun generateUserId(): String {
        currentUserId = (currentUserId % 1000000)
        return "ID_$currentUserId"
    }

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        btn_submit=findViewById<ImageButton>(R.id.btn_submit)
        //sex = findViewById<RadioGroup>(R.id.sexy)
        btn_date=findViewById<ImageButton>(R.id.btn_date)
        age=findViewById<TextView>(R.id.txt_birthday)
        name=findViewById<TextView>(R.id.txt_name)
        account=findViewById<TextView>(R.id.txt_account)
        password=findViewById<TextView>(R.id.txt_password)
        check_pwd=findViewById<TextView>(R.id.txt_ConfirmPassword)
        gender=findViewById<TextView>(R.id.txt_gender)
        userid=findViewById<TextView>(R.id.user_id)
        eye=findViewById<ImageView>(R.id.eye)
        checkeye=findViewById<ImageView>(R.id.checkeye)

        userid = findViewById<TextView>(R.id.user_id)
        // 在這裡設定 UserID 的值
        userid.text = "ID: ${generateUserId()}"


        btn_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    val format = "${setDateFormat(year, month, day)}"
                    age.text = format
                }
            }, year, month, day).show()
        }
        account.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                // 帳號輸入框失去焦點時執行的動作
                val enteredAccount = account.text.toString()
                checkAccountExists(enteredAccount)
            }
        }

        val generatedUserId = generateUserId()
        userid.text = "$generatedUserId"
        
        //外部資料庫存取
        btn_submit.setOnClickListener {
            var userid:String=binding!!.userId.text.toString()
            var Name: String = binding!!.txtName.text.toString()
            var Birthday: String = binding!!.txtBirthday.text.toString()
            var Gender: String = binding!!.txtGender.text.toString()
            var Account: String = binding!!.txtAccount.text.toString()
            var Password: String = binding!!.txtPassword.text.toString()
            var ConfirmPassword: String = binding!!.txtConfirmPassword.text.toString()

            // 檢查密碼和確認密碼是否相同
            if (Password == ConfirmPassword) {
                // 密碼相同，繼續處理
                val Users: MutableMap<String, Any> = HashMap()
                Users["User_id"]=userid
                Users["Name"] = Name
                Users["Birthday"] = Birthday
                Users["Gender"] = Gender
                Users["Account"] = Account
                Users["Password"] = Password
                Users["ConfirmPassword"] = ConfirmPassword

                // 檢查帳號是否存在
                checkAccountExists(Account)

                // 寫入資料庫
                fireStoreDatabase.collection("Users")
                    .add(Users)
                    .addOnSuccessListener {
                        Log.d(TAG, "Added document with Id ${it.id}")
                    }
                    .addOnFailureListener {
                        Log.w(TAG, "Error adding document $it")
                    }

                // 其他程式碼...

                finish()
            } else {
                // 密碼不相同，顯示錯誤訊息或者阻止提交
                showToast("確認密碼有錯，請再輸入一次!!")
            }
        }


        //密碼
        var isHideFirst = true
        eye.setOnClickListener {
            if (isHideFirst === true) {
                eye.setImageResource(R.drawable.eye)
                //密文
                val method1 =
                    HideReturnsTransformationMethod.getInstance()
                password.setTransformationMethod(method1)
                isHideFirst = false
            } else {
                eye.setImageResource(R.drawable.closeeye)
                //密文
                val method: TransformationMethod = PasswordTransformationMethod.getInstance()
                password.setTransformationMethod(method)
                isHideFirst = true
            }
            // 光标的位置
            // 光标的位置
            val index: Int = password.getText().toString().length
            password.setSelection(index)

        }
        //確認密碼
        var isHideFirst1 = true
        checkeye.setOnClickListener {
            if (isHideFirst1 === true) {
                checkeye.setImageResource(R.drawable.eye)
                //密文
                val method1 =
                    HideReturnsTransformationMethod.getInstance()
                check_pwd.setTransformationMethod(method1)
                isHideFirst1 = false
            } else {
                checkeye.setImageResource(R.drawable.closeeye)
                //密文
                val method: TransformationMethod = PasswordTransformationMethod.getInstance()
                check_pwd.setTransformationMethod(method)
                isHideFirst1 = true
            }

            val index: Int = check_pwd.getText().toString().length
            check_pwd.setSelection(index)

        }

    }

    private fun checkAccountExists(account: String) {
        fireStoreDatabase.collection("Users")
            .whereEqualTo("Account", account)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    // Account doesn't exist, you can proceed with registration
                    Log.d(TAG, "Account does not exist, proceed with registration")
                    // ... Existing code ...
                } else {
                    // Account already exists
                    Log.d(TAG, "Account already exists")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
                // Handle the error
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }

}

private fun TextView.setSelection(index: Int) {

}

