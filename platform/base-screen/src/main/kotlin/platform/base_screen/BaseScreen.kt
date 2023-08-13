package platform.base_screen

import android.os.Bundle

interface BaseScreen {

	fun isTransactionSuccessful(bundle: Bundle?): Boolean = true

	fun initBeforeUiCreated() {}

	fun initAfterUiCreated() {}

	fun configure(savedInstanceState: Bundle?) {}
}