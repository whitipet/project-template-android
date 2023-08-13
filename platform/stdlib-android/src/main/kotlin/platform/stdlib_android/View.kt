package platform.stdlib_android

import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener

fun View.retrieveSize(requireNonZeroSides: Boolean = false, action: (width: Int, height: Int) -> Unit) {
	viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
		override fun onGlobalLayout() {
			if (requireNonZeroSides) {
				if (width != 0 && height != 0) viewTreeObserver.removeOnGlobalLayoutListener(this)
			} else viewTreeObserver.removeOnGlobalLayoutListener(this)
			action.invoke(width, height)
		}
	})
}