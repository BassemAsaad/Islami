package com.example.session8_islami.ahadeth

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.utils.Constants
import com.example.session8_islami.R
import com.example.session8_islami.ahadeth.hadeth_adapter.AhadethContentAdapter

class HadethDetailsActivity : AppCompatActivity() {

    private lateinit var hadethTitle : TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var hadethContentAdapter: AhadethContentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)

        hadethTitle = findViewById(R.id.titleHadeth_textview)
        recyclerView = findViewById(R.id.recycler_view_hadeth_Content)

        val hadethContent = intent.getStringExtra(Constants.HADETH_NAME)
        hadethTitle.text = hadethContent

        val hadethPosition = intent.getIntExtra(Constants.HADETH_POSITION,0)
        readHadethFromFile(hadethPosition)

        recyclerView.adapter = hadethContentAdapter


    }

    private fun readHadethFromFile(hadethPosition:Int){

        val fileName = "ahadeth.txt"
        val fileContent = assets.open(fileName).bufferedReader().use{ it.readText() }
        val ahadeth : List<String> = fileContent.split("#")
        hadethContentAdapter = AhadethContentAdapter(ahadeth[hadethPosition])

    }


}