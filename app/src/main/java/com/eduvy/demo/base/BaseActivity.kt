package com.eduvy.demo.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.eduvy.demo.BR
import com.eduvy.demo.R
import com.eduvy.demo.utils.SessionManager
import com.eduvy.demo.utils.extentions.showToast
import org.koin.android.ext.android.inject

abstract class BaseActivity <Binding : ViewDataBinding, ViewModel : BaseViewModel> : AppCompatActivity() {

    private val TAG_NAME: String = "BaseActivityNew"

    protected abstract val mViewModel: ViewModel
    protected lateinit var bindingObject: Binding
    protected val mSessionManager by inject<SessionManager>()


    var appCompatActivity: AppCompatActivity? = null

    fun getViewDataBinding(): Binding = bindingObject

    fun getViewModelObject(): ViewModel = mViewModel

    var isFullScreen: Boolean = false

    open fun drawoverStatusBar(): Boolean = false

    open fun getStatusBarColorForActivity(): Int = R.color.purple_700

    open fun passDataToPreviousActivity(intent: Intent, resultCode: Int = 1234) {
        setResult(resultCode, intent)
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG_NAME, "On $TAG_NAME")
        Log.e(TAG_NAME, "On drawoverStatusBar()=${drawoverStatusBar()}")

        bindingObject = DataBindingUtil.setContentView(this, getLayoutResId())
        doDataBinding()
    }


    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int


    /**
     * Do your other stuff in init after binding layout.
     */
    abstract fun init()

    private fun doDataBinding() {
        bindingObject.lifecycleOwner =
            this // it is extra if you want to set life cycle owner in binding
        // Here your viewModel and binding variable imlementation
        bindingObject.setVariable(
            BR.viewmodel,
            mViewModel
        )  // In all layout the variable name should be "viewModel"
        bindingObject.executePendingBindings()
        init()
        observeViewModelBaseItems()
    }

    private fun observeViewModelBaseItems() {
        with(mViewModel) {
            showToastMessage.observe(this@BaseActivity, {
                showToast(it)
            })
            showToastMessageFromResources.observe(this@BaseActivity, {
                showToast(getString(it))
            })
        }
    }


    open fun hideKeyboard() {
        val view: View? = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
            }
        }
    }


}