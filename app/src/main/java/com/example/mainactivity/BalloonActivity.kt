package com.example.mainactivity

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.annotation.SuppressLint
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator


class BalloonActivity : AppCompatActivity() {

    private lateinit var balloonView: View
    private lateinit var currentAnimatorSet: AnimatorSet

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balloon)
        //設定隱藏標題
        getSupportActionBar()?.hide();

        balloonView = findViewById(R.id.imageViewBalloon)
        balloonView.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startBalloonPopAnimation()
                }
                MotionEvent.ACTION_UP -> {
                    stopBalloonPopAnimation()
                }
            }
            true
        }
        val back5 = findViewById<ImageButton>(R.id.back5)

        back5.setOnClickListener {
            finish()//hello123
//有錯嗎
        }
    // 呼叫氣球的浮動動畫
        startBalloonFloatAnimation()

    }

    // 氣球爆炸動畫
    private fun startBalloonPopAnimation() {
        currentAnimatorSet = AnimatorSet()
        val scaleXAnimator = ObjectAnimator.ofFloat(balloonView, View.SCALE_X, 1.0f, 2.0f)
        val scaleYAnimator = ObjectAnimator.ofFloat(balloonView, View.SCALE_Y, 1.0f, 2.0f)
        val alphaAnimator = ObjectAnimator.ofFloat(balloonView, View.ALPHA, 1.0f, 0.0f)

        scaleXAnimator.interpolator = AccelerateInterpolator()
        scaleYAnimator.interpolator = AccelerateInterpolator()
        // 同時執行X軸、Y軸的縮放動畫和透明度的變化
        currentAnimatorSet.playTogether(scaleXAnimator, scaleYAnimator, alphaAnimator)
        currentAnimatorSet.duration = 5000 // 调整持续时间为5秒
        currentAnimatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // 在动画结束时重新生成气球
                resetBalloon()
            }
        })
        currentAnimatorSet.start()
    }

    // 停止氣球爆炸動畫
    private fun stopBalloonPopAnimation() {
        if (::currentAnimatorSet.isInitialized && currentAnimatorSet.isRunning) {
            currentAnimatorSet.cancel()
        }
    }

    // 重新設定氣球的縮放和透明度
    private fun resetBalloon() {
        balloonView.scaleX = 1.0f
        balloonView.scaleY = 1.0f
        balloonView.alpha = 1.0f
    }

    //氣球浮動
    private fun startBalloonFloatAnimation() {
        // 創建一個ValueAnimator用於垂直方向的位移動畫
        val floatAnimator = ValueAnimator.ofFloat(0f, -30f, 0f)
        floatAnimator.duration = 3000 // 浮動速度 3 秒
        floatAnimator.repeatCount = ValueAnimator.INFINITE
        floatAnimator.repeatMode = ValueAnimator.REVERSE
        floatAnimator.interpolator = LinearInterpolator()
        // 更新氣球的Y軸位移
        floatAnimator.addUpdateListener { animator ->
            val translationY = animator.animatedValue as Float
            balloonView.translationY = translationY
        }

        floatAnimator.start()
    }



    }
