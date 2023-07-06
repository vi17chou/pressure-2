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
    private lateinit var buttonrestart: Button
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
                textView.text = "时间：$time"
                if (timeswitch) {
                    time++
                    sendEmptyMessageDelayed(1, 1000)
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle)
        //設定隱藏標題
        getSupportActionBar()?.hide();

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
        handler.sendEmptyMessageDelayed(1, 1000)
        random()

        val back4 = findViewById<ImageButton>(R.id.back4)

        back4.setOnClickListener {
            finish()

        }

    }

    private fun random() {
        timeswitch = true
        for (i in imageIndex.indices) {
            imageIndex[i] = i
        }
        var rand1: Int
        var rand2: Int
        for (j in 0 until 20) {
            rand1 = (Math.random() * (length - 1)).toInt()
            do {
                rand2 = (Math.random() * (length - 1)).toInt()
                if (rand1 != rand2) {
                    break
                }
            } while (true)
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

    private fun swap(rand1: Int, rand2: Int) {
        val temp = imageIndex[rand1]
        imageIndex[rand1] = imageIndex[rand2]
        imageIndex[rand2] = temp
    }

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

    private fun move(imagbtnId: Int, site: Int) {
        val sitex = site / imagex
        val sitey = site % imagey
        val blankx = blankSwap / imagex
        val blanky = blankSwap % imagey
        val x = Math.abs(sitex - blankx)
        val y = Math.abs(sitey - blanky)
        if ((x == 0 && y == 1) || (x == 1 && y == 0)) {
            val clickButton = findViewById<ImageButton>(imagbtnId)
            clickButton.visibility = View.INVISIBLE
            val blankButton = findViewById<ImageButton>(blankImgid)
            blankButton.setImageDrawable(resources.getDrawable(image[imageIndex[site]]))
            blankButton.visibility = View.VISIBLE
            swap(site, blankSwap)
            blankSwap = site
            blankImgid = imagbtnId
        }
        gameOver()
    }

    private fun restore() {
        handler.removeMessages(1)
        val clickButton = findViewById<ImageButton>(blankImgid)
        clickButton.visibility = View.VISIBLE
        val blankButton = findViewById<ImageButton>(R.id.pt_ib_00x09)
        blankButton.visibility = View.INVISIBLE
        blankImgid = R.id.pt_ib_00x09
        blankSwap = length - 1
    }

    private fun gameOver() {
        var loop = true
        for (i in imageIndex.indices) {
            if (imageIndex[i] != i) {
                loop = false
            }
        }
        if (loop) {
            timeswitch = false
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
            button09.visibility = View.VISIBLE
            handler.removeMessages(1)
            val builder = AlertDialog.Builder(this@PuzzleActivity)
            builder.setMessage("恭喜，拼图成功！您用的时间为$time 秒")
                .setPositiveButton("确认", null)
            val dialog = builder.create()
            dialog.show()
        }
    }

    fun restart(view: View) {
        time = 0
        restore()
        textView.text = "时间：$time"
        timeswitch = true
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


    }
