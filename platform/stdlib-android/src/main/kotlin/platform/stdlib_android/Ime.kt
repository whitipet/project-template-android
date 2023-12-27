package platform.stdlib_android

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.showIme(requestFocus: Boolean = false) {
	if (requestFocus) requestFocus()
	ViewCompat.getWindowInsetsController(this)?.show(WindowInsetsCompat.Type.ime())
}

fun View.hideIme(clearFocus: Boolean = false) {
	if (clearFocus) clearFocus()
	ViewCompat.getWindowInsetsController(this)?.hide(WindowInsetsCompat.Type.ime())
}

fun View.restartInput() = getSystemService(context, InputMethodManager::class.java)?.restartInput(this)