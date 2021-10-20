package edu.temple.imageviewerappextended

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {  }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(requireActivity()).get(ImageViewModel::class.java).getImage().observe(requireActivity(), { image(it) })
    }

    fun image(position: Int){
        imageView = layout.findViewById(R.id.imageView)
        textView = layout.findViewById(R.id.textView)

        imageView.setImageResource(position)
        textView.resources.getStringArray(position)
    }
}