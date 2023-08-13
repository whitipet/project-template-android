package platform.base_screen.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import platform.base_screen.BaseScreen

abstract class BaseModal(@LayoutRes private val layoutResId: Int? = null) : BottomSheetDialogFragment(), BaseScreen {

	override fun onCreate(savedInstanceState: Bundle?) {
		require(isTransactionSuccessful(arguments)) { "Missing required parameters" }

		super.onCreate(savedInstanceState)

		initBeforeUiCreated()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
		if (layoutResId == null) null else inflater.inflate(layoutResId, container, false)

	@CallSuper
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		initAfterUiCreated()

		configure(savedInstanceState)
	}

	fun show(fragmentManager: FragmentManager) {
		if (fragmentManager.findFragmentByTag(this::class.simpleName) != null) return
		show(fragmentManager, this::class.simpleName)
	}
}