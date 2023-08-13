package feature.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import platform.base_screen.activity.bindView
import project.base_screen.activity.TemplateActivity

class HomeActivity : TemplateActivity(R.layout.activity_home) {

	private val btnSettings: View by bindView(R.id.btn_home_setting)

	override fun configure(savedInstanceState: Bundle?) {
		btnSettings.setOnClickListener { startActivity(Intent("template.intent.action.open.SETTINGS")) }
	}
}