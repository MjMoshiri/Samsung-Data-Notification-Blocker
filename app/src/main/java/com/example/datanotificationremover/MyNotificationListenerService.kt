package com.example.datanotificationremover

import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationListenerService : NotificationListenerService() {

    companion object {
        private const val TARGET_PACKAGE = "com.samsung.android.app.telephonyui"
        private const val TARGET_CHANNEL = "channel_mobileNetworksAlert"
        private const val LOG_TAG = "NotificationListener"
        private const val SNOOZE_DURATION_MS = 1000 * 60 * 24L
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        Log.d(LOG_TAG, "Notification Posted from: ${sbn.packageName}")

        if (sbn.packageName == TARGET_PACKAGE && sbn.notification.channelId == TARGET_CHANNEL) {
            Log.d(LOG_TAG, "Notification from package: ${sbn.packageName}, Channel ID: ${sbn.notification.channelId}")
            val canClear = sbn.isClearable
            if (canClear) {
                Log.d(LOG_TAG, "Canceling Notification: ${sbn.key}")
                cancelNotification(sbn.key)
            } else {
                snoozeNotification(sbn.key, SNOOZE_DURATION_MS)
            }
        }
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }
}