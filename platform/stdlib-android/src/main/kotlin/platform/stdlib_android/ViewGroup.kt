package platform.stdlib_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Inflates the given layoutId, and adds it to this ViewGroup if attachToThis is true
 * else use the LayoutParams of this ViewGroup for the new View. Defaults to true.
 *
 * @see LayoutInflater.inflate
 */
inline fun <reified T : View> ViewGroup.inflate(
	@LayoutRes layoutRes: Int,
	attachToRoot: Boolean = true,
): T = LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot) as T