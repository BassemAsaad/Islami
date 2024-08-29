package com.example.session8_islami.quran.quranAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.R
import com.example.session8_islami.quran.data.QuranData

class QuranAdapter (private val items : List<QuranData>) : RecyclerView.Adapter<QuranAdapter.ViewHolder>(){


    //inner class ViewHolder
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView= itemView.findViewById(R.id.sura_name)
        val number : TextView= itemView.findViewById(R.id.total_ayat_inSura)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quran,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.Sura
        holder.number.text = item.total_ayat

        holder.name.setOnClickListener{
            onSuraClickListener?.onSuraClick(position, item)
        }

    }
    interface OnSuraClickListener{
        fun onSuraClick(position: Int, name: QuranData)
    }

    var onSuraClickListener : OnSuraClickListener?=null







}