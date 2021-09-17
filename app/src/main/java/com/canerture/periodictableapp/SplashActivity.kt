package com.canerture.periodictableapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.canerture.periodictableapp.databinding.ActivitySplashBinding

import com.jaredrummler.android.widget.AnimatedSvgView

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        val background = object : Thread() {
            override fun run() {
                try {

                    binding.animatedSvgView.start()

                    sleep(3500)

                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}