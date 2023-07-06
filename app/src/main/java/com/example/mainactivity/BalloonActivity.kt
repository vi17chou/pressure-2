package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.animation.AccelerateInterpolator



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


    }

    private fun startBalloonPopAnimation() {
        currentAnimatorSet = AnimatorSet()
        val scaleXAnimator = ObjectAnimator.ofFloat(balloonView, View.SCALE_X, 1.0f, 2.0f)
        val scaleYAnimator = ObjectAnimator.ofFloat(balloonView, View.SCALE_Y, 1.0f, 2.0f)
        val alphaAnimator = ObjectAnimator.ofFloat(balloonView, View.ALPHA, 1.0f, 0.0f)

        scaleXAnimator.interpolator = AccelerateInterpolator()
        scaleYAnimator.interpolator = AccelerateInterpolator()

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

    private fun stopBalloonPopAnimation() {
        if (::currentAnimatorSet.isInitialized && currentAnimatorSet.isRunning) {
            currentAnimatorSet.cancel()
        }
    }

    private fun resetBalloon() {
        balloonView.scaleX = 1.0f
        balloonView.scaleY = 1.0f
        balloonView.alpha = 1.0f
    }





    }
