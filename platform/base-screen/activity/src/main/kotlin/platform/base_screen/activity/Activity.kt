package platform.base_screen.activity

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

fun <ViewT : View> Activity.bindView(@IdRes idRes: Int): Lazy<ViewT> =
	lazy(LazyThreadSafetyMode.NONE) { findViewById(idRes) }