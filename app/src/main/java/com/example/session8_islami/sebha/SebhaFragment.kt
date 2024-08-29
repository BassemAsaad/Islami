package com.example.session8_islami.sebha

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.session8_islami.R
import com.example.session8_islami.home.HomeActivity
import com.example.session8_islami.utils.Constants

class SebhaFragment : Fragment() {
    private var counter = 0
    private lateinit var tasbehCounter : TextView
    private lateinit var count : Button
    private lateinit var reset : Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbehCounter = view.findViewById(R.id.tasbeh_counter)
        count = view.findViewById(R.id.count)
        reset = view.findViewById(R.id.reset)
        tasbehCounter.text = "عدد التسبيحات:  $counter"
        count.setOnClickListener {
            counter++
            tasbehCounter.text = "عدد التسبيحات:  $counter"
        }
        reset.setOnClickListener {
            counter = 0
            tasbehCounter.text = "عدد التسبيحات:  $counter"
        }

    }

}