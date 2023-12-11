package platform.stdlib_android

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.util.TypedValue.applyDimension
import kotlin.math.roundToInt

private val dm: DisplayMetrics get() = Resources.getSystem().displayMetrics

val Int.dpToPx: Int get() = applyDimension(COMPLEX_UNIT_DIP, this.toFloat(), dm).roundToInt().coerceAtLeast(1)
val Float.dpToPx: Float get() = applyDimension(COMPLEX_UNIT_DIP, this, dm).coerceAtLeast(1.0f)

val Int.spToPx: Int get() = applyDimension(COMPLEX_UNIT_SP, this.toFloat(), dm).roundToInt().coerceAtLeast(1)
val Float.spToPx: Float get() = applyDimension(COMPLEX_UNIT_SP, this, dm).coerceAtLeast(1.0f)