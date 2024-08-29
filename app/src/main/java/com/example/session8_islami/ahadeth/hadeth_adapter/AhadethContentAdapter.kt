package com.example.session8_islami.ahadeth.hadeth_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.R

class AhadethContentAdapter(items:String) : RecyclerView.Adapter<AhadethContentAdapter.ViewHolder>() {

    private var itemsList = mutableListOf<String>()
    init {
        itemsList.addAll(listOf(items))
    }

    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
        val hadethContent : TextView = itemView.findViewById(R.id.content_hadeth)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_content,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.hadethContent.text = item


    }

    fun changeHadethContentData(verses : MutableList<String>){
        itemsList = verses
        notifyDataSetChanged()
    }



}