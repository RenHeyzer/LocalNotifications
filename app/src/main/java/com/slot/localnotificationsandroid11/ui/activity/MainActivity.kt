package com.slot.localnotificationsandroid11.ui.activity

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.slot.localnotificationsandroid11.R
import com.slot.localnotificationsandroid11.ui.utils.MyNotificationReceiver

class MainActivity : AppCompatActivity() {

    private val myNotificationReceiver = MyNotificationReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(myNotificationReceiver, IntentFilter())
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myNotificationReceiver)
    }
}