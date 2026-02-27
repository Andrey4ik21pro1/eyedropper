package com.android.eyedropper.shortcut

import android.service.quicksettings.TileService
import android.content.Intent
import android.app.PendingIntent

class EyeDropperTile : TileService() {
    override fun onClick() {
        super.onClick()
        val intent = Intent(this, PickerActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        startActivityAndCollapse(pendingIntent)
    }
}