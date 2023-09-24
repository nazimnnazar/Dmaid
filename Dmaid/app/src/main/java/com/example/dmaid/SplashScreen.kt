package com.example.dmaid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val backgroundImage: ImageView = findViewById(R.id.imageView2)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        backgroundImage.startAnimation(slideAnimation)

        Handler().postDelayed(Runnable{
            startActivity(Intent(this,First::class.java))
            finish()
        },3000)
    }
}