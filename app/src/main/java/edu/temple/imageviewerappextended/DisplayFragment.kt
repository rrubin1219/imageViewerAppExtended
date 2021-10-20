package edu.temple.imageviewerappextended

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DisplayFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    fun image(position: Int){
        imageView = layout.findViewById(R.id.imageView)
        imageView.setImageResource(position)
    }

    companion object {
        fun newInstance(param1: String, param2: String) = DisplayFragment().apply {
        }
    }
}