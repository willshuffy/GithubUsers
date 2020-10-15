    package com.willshuffyproject.githubusers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

    class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //load animation

        val apps_logo = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
        val text_logo = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)
        val desc_img = AnimationUtils.loadAnimation(this, R.anim.alpha_to_alpha)


        //run animation

        iv_logo.startAnimation(apps_logo)
        tv_logo.startAnimation(text_logo)
        iv_desc.startAnimation(desc_img)

        var handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity,
                MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
