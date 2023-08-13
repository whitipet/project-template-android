package platform.stdlib_android

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.TimeInterpolator
import android.view.View

/**
 * Set the View visibility to VISIBLE. Applies animation on demand
 *
 * @param  animate apply animation
 * @param  animationDuration animation duration, if the animation is active
 * @param  animationInterpolator animation interpolator if animation is active
 */
fun View.visible(
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) = show(animate, animationDuration, animationInterpolator)

/**
 * Set the View visibility to INVISIBLE. Applies animation on demand
 *
 * @param  animate apply animation
 * @param  animationDuration animation duration, if the animation is active
 * @param  animationInterpolator animation interpolator if animation is active
 */
fun View.invisible(
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) = hide(View.INVISIBLE, animate, animationDuration, animationInterpolator)

/**
 * Set the View visibility to GONE. Applies animation on demand
 *
 * @param  animate apply animation
 * @param  animationDuration animation duration, if the animation is active
 * @param  animationInterpolator animation interpolator if animation is active
 */
fun View.gone(
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) = hide(View.GONE, animate, animationDuration, animationInterpolator)

/**
 * Convenient method that chooses between View.visible() or View.invisible() methods.
 * Applies animation on demand
 *
 * @param  animate apply animation
 * @param  animationDuration animation duration, if the animation is active
 * @param  animationInterpolator animation interpolator if animation is active
 */
fun View.visibleOrInvisible(
	show: Boolean,
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) {
	if (show) visible(animate, animationDuration, animationInterpolator)
	else invisible(animate, animationDuration, animationInterpolator)
}

/**
 * Convenient method that chooses between View.visible() or View.gone() methods.
 * Applies animation on demand
 *
 * @param  animate apply animation
 * @param  animationDuration animation duration, if the animation is active
 * @param  animationInterpolator animation interpolator if animation is active
 */
fun View.visibleOrGone(
	show: Boolean,
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) {
	if (show) visible(animate, animationDuration, animationInterpolator)
	else gone(animate, animationDuration, animationInterpolator)
}

private fun View.show(
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) {
	if (animate) animate()
		.alpha(1f)
		.setDuration(animationDuration.toLong())
		.setInterpolator(animationInterpolator)
		.setListener(object : AnimatorListenerAdapter() {
			override fun onAnimationStart(animation: Animator) {
				visibility = View.VISIBLE
			}
		})
	else visibility = View.VISIBLE
}

private fun View.hide(
	hidingStrategy: Int,
	animate: Boolean = false,
	animationDuration: Int = 400,
	animationInterpolator: TimeInterpolator? = null,
) {
	if (animate) animate()
		.alpha(0f)
		.setDuration(animationDuration.toLong())
		.setInterpolator(animationInterpolator)
		.setListener(object : AnimatorListenerAdapter() {
			override fun onAnimationEnd(animation: Animator) {
				visibility = hidingStrategy
			}
		})
	else visibility = hidingStrategy
}