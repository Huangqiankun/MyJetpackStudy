package com.hqk.room2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hqk.room2.databinding.ItemBinding
import java.lang.String

class StudentRecyclerViewAdapter() :
    RecyclerView.Adapter<StudentRecyclerViewAdapter.MyViewHolder>() {

    var students: List<Student>? = null

    constructor(students: List<Student>) : this() {
        this.students = students
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemBinding: ItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item, parent, false
        )
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = students!![position]
        holder.itemBinding!!.student = student
//        val tvId = holder.itemView.findViewById<TextView>(R.id.tvId)
//        tvId.text = String.valueOf(student.id)
//
//        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
//        tvName.text = student.name
//
//        val tvAge = holder.itemView.findViewById<TextView>(R.id.tvAge)
//        tvAge.text = String.valueOf(student.age)
    }

    override fun getItemCount(): Int {
        return students!!.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemBinding: ItemBinding? = null

        constructor(itemBinding: ItemBinding) : this(itemBinding.root) {
            this.itemBinding = itemBinding
        }

    }
}