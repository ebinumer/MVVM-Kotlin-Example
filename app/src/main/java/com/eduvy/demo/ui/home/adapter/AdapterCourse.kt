package com.eduvy.demo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eduvy.demo.data.model.CoursesModelData
import com.eduvy.demo.data.model.DiffUtilCoursesModelData
import com.eduvy.demo.databinding.RecyclerLayoutCoursesBinding
import timber.log.Timber

class AdapterCourse ( private val mListener: OnCourseClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var mListItem: MutableList<CoursesModelData> = arrayListOf()

    fun setListItem(mData: List<CoursesModelData>) {
        val diff= DiffUtilCoursesModelData(this.mListItem,mData)
        val res= DiffUtil.calculateDiff(diff)
        this.mListItem.clear()
        this.mListItem.addAll(mData)
        res.dispatchUpdatesTo(this)
    }

    fun mClearData(){
        this.mListItem.clear()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewholderCourse(
            RecyclerLayoutCoursesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mListItem[position]?.let {
            (holder as ViewholderCourse).bind(
                mListener,it
            )

        }
    }

    override fun getItemCount() = mListItem.size

    inner class ViewholderCourse(val mBinding: RecyclerLayoutCoursesBinding) :
        RecyclerView.ViewHolder(
            mBinding.root
        ) {
        fun bind(mListener: OnCourseClickListener, mData: CoursesModelData) {
            mBinding.data = mData
            mBinding.root.setOnClickListener {
                mListener.onCourseClickListener(
                    mData, adapterPosition
                )
            }
        }
    }
}
interface OnCourseClickListener {
    fun onCourseClickListener(mData: CoursesModelData, position: Int)
}