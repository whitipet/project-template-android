package platform.stdlib_android.lifecycle_aware_lazy

import androidx.annotation.MainThread
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import java.io.Serializable

fun <T> LifecycleOwner.lifecycleAwareLazy(initializer: () -> T): Lazy<T> = LifecycleAwareLazy(this, initializer)

private object UninitializedValue

class LifecycleAwareLazy<out T>(
	private val lifecycleOwner: LifecycleOwner,
	private val initializer: () -> T,
) : Lazy<T>, Serializable, LifecycleEventObserver {

	private var _value: Any? = UninitializedValue

	override val value: T
		@MainThread
		get() {
			if (_value === UninitializedValue) {
				_value = initializer()
				attachToLifecycle()
			}
			@Suppress("UNCHECKED_CAST")
			return _value as T
		}

	override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
		if (event == Lifecycle.Event.ON_DESTROY) {
			_value = UninitializedValue
			detachFromLifecycle()
		}
	}

	private fun attachToLifecycle() {
		if (getLifecycle().currentState == Lifecycle.State.DESTROYED)
			throw IllegalStateException("Initialization failed because lifecycle has been destroyed!")

		getLifecycle().addObserver(this)
	}

	private fun detachFromLifecycle() = getLifecycle().removeObserver(this)

	private fun getLifecycle(): Lifecycle = when (lifecycleOwner) {
		is androidx.fragment.app.Fragment -> lifecycleOwner.viewLifecycleOwner.lifecycle
		else -> lifecycleOwner.lifecycle
	}

	override fun isInitialized(): Boolean = _value !== UninitializedValue

	override fun toString(): String = if (isInitialized()) value.toString() else "Lazy value not initialized yet."
}