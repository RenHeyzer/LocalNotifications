package com.slot.localnotificationsandroid11.ui.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyNotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let { c ->
            MyNotificationService(c).apply {
                intent?.let {
                    if (it.action.equals("SEND_NOTIFICATION")) {
                        multiLet(
                            it.getIntExtra("ID", 1),
                            it.getStringExtra("DES")
                        ) { id, description ->
                            showNotification(id, description)
                        }
                    }
                }
            }
        }
    }
}