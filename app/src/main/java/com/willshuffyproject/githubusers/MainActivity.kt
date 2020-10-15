package com.willshuffyproject.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load animation

        val apps_logo = AnimationUtils.loadAnimation(this, R.anim.alpha_with_scale)
        val text_logo = AnimationUtils.loadAnimation(this, R.anim.alpha_with_scale)


        //run animation

        iv_logo.startAnimation(apps_logo)
        tv_logo.startAnimation(text_logo)
    }
}
