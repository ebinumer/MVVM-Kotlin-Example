package com.eduvy.demo.utils.bindingUtils

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.eduvy.demo.R

@BindingAdapter("imageUrl")
fun setImageFromUrl(mImageView: ImageView, valItem: String?) {
    valItem?.let {
        mImageView.context?.let {
            Glide.with(it)
                .load(valItem)
//                .placeholder(ContextCompat.getDrawable(it, R.drawable.demo_img))
                .into(mImageView)


        }
    }
}