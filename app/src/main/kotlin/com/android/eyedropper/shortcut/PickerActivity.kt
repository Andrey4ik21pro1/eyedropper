package com.android.eyedropper.shortcut

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PickerActivity : AppCompatActivity() {
    private val eyeDropperLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val color = result.data?.getIntExtra(Intent.EXTRA_COLOR, Color.BLACK) ?: Color.BLACK
            showColor(color) // Use the picked color in your app
        }
        finish()
    }

    fun launchColorPicker() {
        val intent = Intent(Intent.ACTION_OPEN_EYE_DROPPER)
        eyeDropperLauncher.launch(intent)
    }

    fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("color", text)
        clipboard.setPrimaryClip(clip)
    }

    fun showColor(color: Int) {
        val hexColor = String.format("#%06X", (0xFFFFFF and color))
        copyToClipboard(hexColor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchColorPicker()
    }
}