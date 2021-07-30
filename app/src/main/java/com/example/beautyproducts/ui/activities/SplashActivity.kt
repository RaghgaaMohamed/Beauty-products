


package com.example.beautyproducts.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.beautyproducts.R
import com.example.beautyproducts.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //start animation
        val zoom = AnimationUtils.loadAnimation(this , R.anim.zoom)
        binding.ivCircle.startAnimation(zoom)

        //sleep activity for two seconds
        var mhandler = Handler()
        val mRunnable : Runnable = object :Runnable{
            override fun run() {
                startActivity(Intent(this@SplashActivity , MainActivity::class.java))
            }
        }
        mhandler.postDelayed(mRunnable , 3000)



    }
}