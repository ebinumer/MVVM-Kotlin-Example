package com.eduvy.demo.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class CoursesModel (
    @SerializedName("status") var status : String,
    @SerializedName("data") var data : List<CoursesModelData>,
    @SerializedName("error") var error : String
        )

data class CoursesModelData(
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("description") var description : String,
    @SerializedName("fee") var fee : Int,
    @SerializedName("image") var image : String

)

class DiffUtilCoursesModelData(
    private val oldList: List<CoursesModelData>,
    private val newList: List<CoursesModelData>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}