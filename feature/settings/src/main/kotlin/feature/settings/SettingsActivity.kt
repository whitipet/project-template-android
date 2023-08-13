package feature.settings

import android.content.Intent
import android.os.Bundle
import android.view.View
import platform.base_screen.activity.BaseActivity
import platform.base_screen.activity.bindView

class SettingsActivity : BaseActivity(R.layout.activity_settings) {

	private val btnHome: View by bindView(R.id.btn_settings_home)

	override fun configure(savedInstanceState: Bundle?) {
		btnHome.setOnClickListener { startActivity(Intent("template.intent.action.open.HOME")) }
	}
}