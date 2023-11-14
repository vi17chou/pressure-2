package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.TextView
import android.app.Activity
import android.app.AlertDialog
import android.util.Log

class PuzzleActivity : AppCompatActivity() {

    private lateinit var button01: ImageButton
    private lateinit var button02: ImageButton
    private lateinit var button03: ImageButton
    private lateinit var button04: ImageButton
    private lateinit var button05: ImageButton
    private lateinit var button06: ImageButton
    private lateinit var button07: ImageButton
    private lateinit var button08: ImageButton
    private lateinit var button09: ImageButton
    private lateinit var buttonrestart: ImageButton
    private lateinit var textView: TextView
    private var imagex = 3
    private var imagey = 3
    private var imgCount = imagex * imagey
    private var length = imgCount
    private var blankSwap = length - 1
    private var blankImgid = R.id.pt_ib_00x09
    private var time = 0
    private var timeswitch = true
    private val imageIndex = IntArray(length)
    private val image = intArrayOf(
        R.drawable.xy9_01, R.drawable.xy9_02, R.drawable.xy9_03,
        R.drawable.xy9_04, R.drawable.xy9_05, R.drawable.xy9_06,
        R.drawable.xy9_07, R.drawable.xy9_08, R.drawable.xy9_09
    )

    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == 1) {
                textView.text = "時間：$time"
                if (timeswitch) {
                    time++
                    sendEmptyMessageDelayed(1, 1000)
                }
            }
        }
    }


    private fun showGameInstructions() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("遊戲說明")
        builder.setMessage("在遊戲中，您需要點擊拼圖，並與空白區塊交换位置將他們按照正确的顺序排列，直到拼圖成功!")
        builder.setPositiveButton("確認") { dialog, which ->
            // 用户點擊確認按鈕後開始計時遊戲
            startGame()
        }
        builder.show()
    }


   //開始遊戲計時
    private fun startGame() {
        time = 0
        restore()
        textView.text = "時間：$time"
        timeswitch = true
       //每隔 1 秒更新一次遊戲界面中的時間顯示
        handler.sendEmptyMessageDelayed(1, 1000)
        button01.isClickable = true
        button02.isClickable = true
        button03.isClickable = true
        button04.isClickable = true
        button05.isClickable = true
        button06.isClickable = true
        button07.isClickable = true
        button08.isClickable = true
        button09.isClickable = true
        random()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle)
        //設定隱藏標題
        getSupportActionBar()?.hide();

        // 顯示遊戲說明AlertDialog
        showGameInstructions()

        button01 = findViewById(R.id.pt_ib_00x01)
        button02 = findViewById(R.id.pt_ib_00x02)
        button03 = findViewById(R.id.pt_ib_00x03)
        button04 = findViewById(R.id.pt_ib_00x04)
        button05 = findViewById(R.id.pt_ib_00x05)
        button06 = findViewById(R.id.pt_ib_00x06)
        button07 = findViewById(R.id.pt_ib_00x07)
        button08 = findViewById(R.id.pt_ib_00x08)
        button09 = findViewById(R.id.pt_ib_00x09)
        textView = findViewById(R.id.pt_tv_time)
        buttonrestart = findViewById(R.id.pt_btn_restart)
        //每隔 1 秒更新一次遊戲界面中的時間顯示
        handler.sendEmptyMessageDelayed(1, 1000)
        random()

        val back4 = findViewById<ImageButton>(R.id.back4)

        back4.setOnClickListener {
            finish()

        }
        val buttonRestart = findViewById<ImageButton>(R.id.pt_btn_restart)

        buttonRestart.setOnClickListener {
            restart(it)
        }
    }

    //隨機打亂拼圖
    private fun random() {
        //計時器是否開始計時
        timeswitch = true
        for (i in imageIndex.indices) {
            imageIndex[i] = i
        }
        //用於儲存随機生成的值
        var rand1: Int
        var rand2: Int
        //随機打亂拼圖排列的次数
        for (j in 0 until 20) {
          //  生成一個随機變數 rand1，範圍 0 到 length - 1 之間，其中 length 表示拼圖數量。
            rand1 = (Math.random() * (length - 1)).toInt()
            //生成一個随機變數 rand2，確保與 rand1 不相同
            do {
                rand2 = (Math.random() * (length - 1)).toInt()
                if (rand1 != rand2) {
                    break
                }
            } while (true)
            //用 swap 函数，交换 rand1 和 rand2 位置的拼圖，打亂它們的排列。
            swap(rand1, rand2)
        }
        button01.setImageDrawable(resources.getDrawable(image[imageIndex[0]]))
        button02.setImageDrawable(resources.getDrawable(image[imageIndex[1]]))
        button03.setImageDrawable(resources.getDrawable(image[imageIndex[2]]))
        button04.setImageDrawable(resources.getDrawable(image[imageIndex[3]]))
        button05.setImageDrawable(resources.getDrawable(image[imageIndex[4]]))
        button06.setImageDrawable(resources.getDrawable(image[imageIndex[5]]))
        button07.setImageDrawable(resources.getDrawable(image[imageIndex[6]]))
        button08.setImageDrawable(resources.getDrawable(image[imageIndex[7]]))
        button09.setImageDrawable(resources.getDrawable(image[imageIndex[8]]))
    }

   //交換拼圖位置
    //用于交換兩個拼圖在 imageIndex 中的位置。有兩個参数 rand1 和 rand2，分别表示要交換的兩個拼圖在 imageIndex 数组中的索引
    private fun swap(rand1: Int, rand2: Int) {
      // 用於存 imageIndex 中 為rand1 的元素的值。
        val temp = imageIndex[rand1]
        imageIndex[rand1] = imageIndex[rand2]
        imageIndex[rand2] = temp
    }

//點擊拼圖
    fun onClick(view: View) {
        val id = view.id
        when (id) {
            R.id.pt_ib_00x01 -> move(R.id.pt_ib_00x01, 0)
            R.id.pt_ib_00x02 -> move(R.id.pt_ib_00x02, 1)
            R.id.pt_ib_00x03 -> move(R.id.pt_ib_00x03, 2)
            R.id.pt_ib_00x04 -> move(R.id.pt_ib_00x04, 3)
            R.id.pt_ib_00x05 -> move(R.id.pt_ib_00x05, 4)
            R.id.pt_ib_00x06 -> move(R.id.pt_ib_00x06, 5)
            R.id.pt_ib_00x07 -> move(R.id.pt_ib_00x07, 6)
            R.id.pt_ib_00x08 -> move(R.id.pt_ib_00x08, 7)
            R.id.pt_ib_00x09 -> move(R.id.pt_ib_00x09, 8)
        }
    }

    //移動拼圖
    private fun move(imagbtnId: Int, site: Int) {
        //用於計算被點擊的拼圖的位置坐标，sitex 表示横向坐標，sitey 表示縱向坐標
        val sitex = site / imagex
        val sitey = site % imagey
        //用於獲取空白塊的位置坐標
        val blankx = blankSwap / imagex
        val blanky = blankSwap % imagey
        //計算被點擊的拼圖與空白區域之間的横向和縱向距離差，分别存在 x 和 y ，這些差值用來判断是否可以移動拼圖
        val x = Math.abs(sitex - blankx)
        val y = Math.abs(sitey - blanky)
        //用於檢查被點擊的拼圖是否可以與空白區域交換位置。如果 x 和 y 的差值中有一个為 1（表示相鄰的位置），則允許移動
        if ((x == 0 && y == 1) || (x == 1 && y == 0)) {
            //用于查找並獲取被點擊的拼圖(ImageButton )，並存在 clickButton
            val clickButton = findViewById<ImageButton>(imagbtnId)
            //將被點擊的拼圖設置為不可見，表示拼圖被移走。
            clickButton.visibility = View.INVISIBLE
            //用於查找並獲取目前的空白區域(ImageButton)並存在 blankButton
            val blankButton = findViewById<ImageButton>(blankImgid)
            //將空白區域的拼圖設置為被點擊的拼圖。这是拼圖交换位置的效果。
            blankButton.setImageDrawable(resources.getDrawable(image[imageIndex[site]]))
            //將空白區域設置為可見，表示空白區域移動到了被點擊的拼圖的位置。
            blankButton.visibility = View.VISIBLE
           // 用 swap 方法，用來交换 imageIndex 数组中的值，以實際執行拼圖的移動。
            swap(site, blankSwap)
            //更新 blankSwap 的值，以反映空白區域的新位置。
            blankSwap = site
           // 更新 blankImgid ，以反映空白區域所在的 ImageButton  id。
            blankImgid = imagbtnId
        }
        //用於檢查遊戲是否已结束。
        gameOver()
    }

//還原遊戲狀態
    private fun restore() {
        // 用於停止或取消計時
        handler.removeMessages(1)
        val clickButton = findViewById<ImageButton>(blankImgid)
        //初始空白區域（clickButton）設置為可見
        clickButton.visibility = View.VISIBLE
        val blankButton = findViewById<ImageButton>(R.id.pt_ib_00x09)
        //初始空白區域（blankButton）設置為不可見
        blankButton.visibility = View.INVISIBLE
        //將 blankImgid 更新為初始空白區域的 id，以确保在下一次移動時，正确的空白區域將被操作
        blankImgid = R.id.pt_ib_00x09
        blankSwap = length - 1
    }

    //判斷遊戲是否結束
    private fun gameOver() {
        var finish = true
        //在for迴圈中，檢查每個拼圖(imageIndex[i])是否在正確的位置，如果是遊戲就結束，timeswitch就會停止計時
        for (i in imageIndex.indices) {
            if (imageIndex[i] != i) {
                finish = false
            }
        }
        if (finish) {
            timeswitch = false
            //是否可點擊(isClickable)
            button01.isClickable = false
            button02.isClickable = false
            button03.isClickable = false
            button04.isClickable = false
            button05.isClickable = false
            button06.isClickable = false
            button07.isClickable = false
            button08.isClickable = false
            button09.isClickable = false
            button09.setImageDrawable(resources.getDrawable(image[8]))
            button09.visibility = View.VISIBLE//用於是否可見
           // 用於停止或取消計時
            handler.removeMessages(1)
            val builder = AlertDialog.Builder(this@PuzzleActivity)
            builder.setMessage("恭喜，拼圖成功！您用的時間為$time 秒")
                .setPositiveButton("確認", null)
            val dialog = builder.create()
            dialog.show()
        }
    }

    //重新開始遊戲
    fun restart(view: View) {
        Log.d("PuzzleActivity", "Restart button clicked")
        time = 0
        restore()
        textView.text = "時間：$time"
        timeswitch = true
        //每隔 1 秒更新一次遊戲界面中的時間顯示
        handler.sendEmptyMessageDelayed(1, 1000)
        //是否可點擊(isClickable)
        button01.isClickable = true
        button02.isClickable = true
        button03.isClickable = true
        button04.isClickable = true
        button05.isClickable = true
        button06.isClickable = true
        button07.isClickable = true
        button08.isClickable = true
        button09.isClickable = true
        random()
    }


    }
