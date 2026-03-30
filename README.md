
# EyeDropper

![License](https://img.shields.io/badge/License-GPL%20v3.0-blue?style=for-the-badge)  ![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white) ![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)

### A system-native color picker tile for Android 17

---
## Reference
A lightweight app that adds a color picker tile to the Quick Settings panel using the system-native eyedropper.

**Requirements:** Android 17 Beta 2+ or Android CANARY 2510+.

---

## API
This app uses the **Android 17 EyeDropper API** (API Level 37). It functions as a system tile that triggers the `android.intent.action.OPEN_EYE_DROPPER` intent, receives the selected color as an integer, converts it to HEX format, and copies it to the clipboard.

For more information, visit the Google Blog:
https://android-developers.googleblog.com/2026/02/the-second-beta-of-android-17.html

**Code Example:**
```Kotlin
val eyeDropperLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
    if (result.resultCode == Activity.RESULT_OK) {
        val color = result.data?.getIntExtra(Intent.EXTRA_COLOR, Color.BLACK)
        // Use the picked color in your app
    }
}

fun launchColorPicker() {
    val intent = Intent(Intent.ACTION_OPEN_EYE_DROPPER)
    eyeDropperLauncher.launch(intent)
}
```

---

## Download the app
- You can get latest EyeDropper build via GitHub Releases: https://github.com/andrey4ik21pro1/eyedropper/releases

---

## Build
- To build the APK from source, run:

```bash
git clone https://github.com/andrey4ik21pro1/eyedropper.git
cd eyedropper
./gradlew assembleDebug
```
- The APK will be available in `app/build/outputs/apk/debug/`.

---

## License

This project is distributed under the **GNU General Public License
v3.0**.\
See the `LICENSE` file for details.
