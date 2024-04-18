package com.example.datanotificationremover

import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationListenerService : NotificationListenerService() {

    companion object {
        private const val TARGET_PACKAGE = "com.samsung.android.app.telephonyui"
        private const val TARGET_CHANNEL = "channel_mobileNetworksAlert"
        private const val SNOOZE_DURATION_MS = 1000 * 60 * 24 * 1000L
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        if (sbn.packageName == TARGET_PACKAGE && sbn.notification.channelId == TARGET_CHANNEL) {
            val canClear = sbn.isClearable
            if (canClear) {
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