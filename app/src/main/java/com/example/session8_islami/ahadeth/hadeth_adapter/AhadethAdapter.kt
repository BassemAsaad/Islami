package com.example.session8_islami.ahadeth.hadeth_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.R

class AhadethAdapter(private val items : List<String>) : RecyclerView.Adapter<AhadethAdapter.ViewHolder>() {

    //inner Class View Holder
    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){

        val hadethName : TextView = itemView.findViewById(R.id.hadeth_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.hadethName.text = item

        holder.hadethName.setOnClickListener{
            onHadethClickListener?.onHadethClick(position, item)
        }
    }

    interface OnHadethClickListener{
        fun onHadethClick(position: Int, item : String)
    }
    var onHadethClickListener: OnHadethClickListener?=null

}