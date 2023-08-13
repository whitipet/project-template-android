package platform.base_screen.modal

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import platform.stdlib_android.lifecycle_aware_lazy.lifecycleAwareLazy
import kotlin.reflect.KClass

fun KClass<out BaseModal>.createInstance(args: Bundle? = null): BaseModal = java.newInstance().createInstance(args)

private fun BaseModal.createInstance(args: Bundle? = null): BaseModal = this.apply { arguments = args }

fun <ViewT : View> BaseModal.bindView(@IdRes idRes: Int): Lazy<ViewT> = lifecycleAwareLazy { findViewById(idRes) }

fun <T : View?> BaseModal.findViewById(@IdRes id: Int): T = requireView().findViewById(id)