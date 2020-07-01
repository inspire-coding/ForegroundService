package com.inspirecoding.foregroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getString(R.string.app_name)

        btn_startService.setOnClickListener {
            startService()
        }
        btn_finishService.setOnClickListener {
            finishService()
        }
    }
    private fun startService() {
        val text = et_text.text.toString()
        val serviceIntent = Intent(this,
            ForegroundService::class.java)
        serviceIntent.putExtra("text", text)
        ContextCompat.startForegroundService(this, serviceIntent)
    }
    private fun finishService() {
        val serviceIntent = Intent(this,
            ForegroundService::class.java)
        stopService(serviceIntent)
    }
}
