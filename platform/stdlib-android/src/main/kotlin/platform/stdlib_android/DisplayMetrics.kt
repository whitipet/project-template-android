package platform.stdlib_android

import android.content.res.Resources

val Int.dp2px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Float.dp2px: Float get() = this * Resources.getSystem().displayMetrics.density

val Int.sp2px: Int get() = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()
val Float.sp2px: Float get() = this * Resources.getSystem().displayMetrics.scaledDensity