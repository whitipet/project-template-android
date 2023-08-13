package platform.base_screen.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import platform.stdlib_android.lifecycle_aware_lazy.lifecycleAwareLazy
import kotlin.reflect.KClass

fun KClass<out Fragment>.createInstance(args: Bundle? = null): Fragment = java.newInstance().createInstance(args)

private fun Fragment.createInstance(args: Bundle? = null): Fragment = this.apply { arguments = args }

fun <ViewT : View> Fragment.bindView(@IdRes idRes: Int): Lazy<ViewT> = lifecycleAwareLazy { findViewById(idRes) }

fun <T : View?> Fragment.findViewById(@IdRes id: Int): T = requireView().findViewById(id)