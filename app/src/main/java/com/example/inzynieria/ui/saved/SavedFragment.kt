package com.example.inzynieria.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.inzynieria.R

class SavedFragment : Fragment() {

    private lateinit var savedViewModel: SavedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedViewModel =
            ViewModelProviders.of(this).get(SavedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_saved, container, false)
        val textView: TextView = root.findViewById(R.id.text_saved)
        savedViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}