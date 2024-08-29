package com.example.session8_islami.quran.quranAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.R

class SuraContentAdapter (): RecyclerView.Adapter<SuraContentAdapter.ViewHolder> (){
    var items_list :List<String>?=null


    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val contentSura : TextView = itemView.findViewById(R.id.content_sura)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura_content,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
            return items_list?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item_content = items_list?.get(position)
        holder.contentSura.setText(item_content)

    }

    fun changeSura_ContentData(verses : List<String>){
        items_list = verses
        //reload
        notifyDataSetChanged()
    }

}