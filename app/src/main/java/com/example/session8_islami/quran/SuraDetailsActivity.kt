package com.example.session8_islami.quran

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.utils.Constants
import com.example.session8_islami.R
import com.example.session8_islami.quran.quranAdapter.SuraContentAdapter

class SuraDetailsActivity : AppCompatActivity() {

    private lateinit var suraTitle : TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var suraContentAdapter: SuraContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        suraTitle = findViewById(R.id.titleSura_textview)


        recyclerView = findViewById(R.id.recyclerView_suraContent)
        suraContentAdapter = SuraContentAdapter()
        recyclerView.adapter = suraContentAdapter

        //receive data from constants
        val suraName = intent.getStringExtra(Constants.SURA_NAME)
        val suraPosition = intent.getIntExtra(Constants.SURA_POSITION,-1)

        suraTitle.text = suraName
        readSuraFile(suraPosition)




    }

    private fun readSuraFile(pos :Int){
        val fileName = "${pos+1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use{ it.readText() }
        val verses : List<String> = fileContent.split("\n")

        //show verses in recyclerView
        suraContentAdapter.changeSura_ContentData(verses)


    }



}