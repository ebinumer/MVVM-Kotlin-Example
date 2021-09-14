package com.eduvy.demo.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class InstitutionModel(
    @SerializedName("status") var status : String,
    @SerializedName("data") var data : List<InstitutionModelData>,
    @SerializedName("error") var error : String
)

data class InstitutionModelData(
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("email") var email : String,
    @SerializedName("phone") var phone : String,
    @SerializedName("address") var address : String,
    @SerializedName("image") var image : String,
    @SerializedName("logo") var logo : String,
    @SerializedName("description") var description : String
)

class DiffUtilInstitutionModelData(
    private val oldList: List<InstitutionModelData>,
    private val newList: List<InstitutionModelData>
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