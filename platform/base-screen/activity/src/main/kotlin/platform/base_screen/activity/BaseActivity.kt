package platform.base_screen.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import platform.base_screen.BaseScreen

abstract class BaseActivity(@LayoutRes private val layoutResId: Int? = null) : AppCompatActivity(), BaseScreen {

	final override fun onCreate(savedInstanceState: Bundle?) {
		require(isTransactionSuccessful(intent?.extras)) { "Missing required parameters" }

		super.onCreate(savedInstanceState)

		initBeforeUiCreated()

		if (layoutResId != null) setContentView(layoutResId)

		initAfterUiCreated()

		configure(savedInstanceState)
	}

	//region Override lock
	final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) =
		super.onCreate(savedInstanceState, persistentState)

	final override fun onPointerCaptureChanged(hasCapture: Boolean) {}
	//endregion Override lock
}