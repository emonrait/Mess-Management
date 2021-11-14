package com.emon.raihan.messmanagement.view.homepage

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ProgressBar
import com.emon.raihan.messmanagement.MainActivity
import com.emon.raihan.messmanagement.R
import java.util.*

class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var timer: Timer
    private var i = 0
    private lateinit var animator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController!!.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        progressBar = findViewById(R.id.prgressbar_id)
        animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100)

        animator.duration = 3000
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                //Toast.makeText(this@SplashScreen, "anim", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
        })


        handler = Handler()
        runnable = Runnable {
            timer.cancel()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }
        }, 3500, 3000)
    }
}