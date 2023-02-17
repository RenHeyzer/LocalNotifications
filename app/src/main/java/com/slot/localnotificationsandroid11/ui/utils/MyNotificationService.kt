package com.slot.localnotificationsandroid11.ui.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.slot.localnotificationsandroid11.R

class MyNotificationService(
    private val context: Context
) {

    private val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(notificationId: Int, description: String) {
        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification_icon)
            .setContentTitle("Hello, World!")
            .setContentText(description)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(notificationId, notificationBuilder)
    }

    companion object {
        const val CHANNEL_ID = "first_channel"
    }
}