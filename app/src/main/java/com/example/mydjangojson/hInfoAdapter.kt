package com.example.mydjangojson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hinfo.view.*

class hInfoAdapter(var items: List<hInfo>) : RecyclerView.Adapter<hInfoAdapter.ViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hInfoAdapter.ViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.hinfo,parent,false)
   return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: hInfoAdapter.ViewHolder, position: Int) {
       val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun setItem(item:hInfo){
            itemView.textView.text = item.name
            itemView.textView2.text = item.phone_number
            itemView.textView3.text = item.address


        }
    }
}