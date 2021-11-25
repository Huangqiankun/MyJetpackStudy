package com.hqk.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.String

class StudentRecyclerViewAdapter() :
    RecyclerView.Adapter<StudentRecyclerViewAdapter.MyViewHolder>() {

    var students: List<Student>? = null

    constructor(students: List<Student>) : this() {
        this.students = students
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = students!![position]
        val tvId = holder.itemView.findViewById<TextView>(R.id.tvId)
        tvId.text = String.valueOf(student.id)

        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
        tvName.text = student.name

        val tvAge = holder.itemView.findViewById<TextView>(R.id.tvAge)
        tvAge.text = String.valueOf(student.age)
    }

    override fun getItemCount(): Int {
        return students!!.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}