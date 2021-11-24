package com.hqk.databinding6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hqk.databinding6.databinding.ItemBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var listUserInfo: List<UserInfo> = ArrayList<UserInfo>()

    constructor(listUserInfo: List<UserInfo>) : this() {
        this.listUserInfo = listUserInfo
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemBinding: ItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item, parent, false
        )

        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var userInfo = listUserInfo[position]
        holder.itemBinding!!.userInfo = userInfo
    }

    override fun getItemCount(): Int {
        return listUserInfo.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemBinding: ItemBinding? = null

        constructor(itemBinding: ItemBinding) : this(itemBinding.root) {
            this.itemBinding = itemBinding
        }

    }
}