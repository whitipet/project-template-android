package platform.stdlib_android

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat.Type.ime

fun View.showIme(requestFocus: Boolean = false) {
	if (requestFocus) requestFocus()
	getWindows()?.let { w -> WindowCompat.getInsetsController(w, this).show(ime()) }
}

fun View.hideIme(clearFocus: Boolean = false) {
	if (clearFocus) clearFocus()
	getWindows()?.let { w -> WindowCompat.getInsetsController(w, this).hide(ime()) }
}

private fun View.getWindows(): Window? {
	var c: Context = context
	while (c is ContextWrapper) {
		if (c is Activity) return c.window
		c = c.baseContext
	}
	return null
}

fun View.restartInput() = getSystemService(context, InputMethodManager::class.java)?.restartInput(this)