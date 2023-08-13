package project.base_screen.activity

import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.core.view.WindowCompat
import platform.base_screen.activity.BaseActivity

abstract class TemplateActivity(@LayoutRes layoutResId: Int? = null) : BaseActivity(layoutResId) {

	@CallSuper
	override fun initBeforeUiCreated() {
		super.initAfterUiCreated()

		WindowCompat.setDecorFitsSystemWindows(window, true)
	}
}