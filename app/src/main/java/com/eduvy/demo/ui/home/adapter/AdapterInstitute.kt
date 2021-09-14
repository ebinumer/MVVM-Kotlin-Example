package com.eduvy.demo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eduvy.demo.data.model.DiffUtilInstitutionModelData
import com.eduvy.demo.data.model.InstitutionModelData
import com.eduvy.demo.databinding.RecyclerLayoutInstituteBinding

class AdapterInstitute ( private val mListener: OnInstituteClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var mListItem: MutableList<InstitutionModelData> = arrayListOf()

    fun setListItem(mData: List<InstitutionModelData>) {
        val diff= DiffUtilInstitutionModelData(this.mListItem,mData)
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
        return ViewholderInstitute(
            RecyclerLayoutInstituteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mListItem[position]?.let {
            (holder as ViewholderInstitute).bind(
                mListener,it
            )

        }
    }

    override fun getItemCount() = mListItem.size

    inner class ViewholderInstitute(val mBinding: RecyclerLayoutInstituteBinding) :
        RecyclerView.ViewHolder(
            mBinding.root
        ) {
        fun bind(mListener: OnInstituteClickListener, mData: InstitutionModelData) {
            mBinding.data = mData
            mBinding.root.setOnClickListener {
                mListener.onInstituteClickListener(
                    mData, adapterPosition
                )
            }
        }
    }
}
interface OnInstituteClickListener {
    fun onInstituteClickListener(mData: InstitutionModelData, position: Int)
}