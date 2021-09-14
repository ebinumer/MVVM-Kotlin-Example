package com.eduvy.demo.utils.bindingUtils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.eduvy.demo.R
import com.eduvy.demo.utils.SessionManager
import org.koin.core.KoinComponent
import org.koin.core.inject

@BindingAdapter("course_price")
fun setCoursePrice(mView: TextView, nValues: Int) {
    nValues?.let {
        val mSessionManager = object : KoinComponent {
            val ms by inject<SessionManager>()
        }.ms
        mView.text ="${mView.context.getString(R.string.product_price)}$nValues"
    }
}
