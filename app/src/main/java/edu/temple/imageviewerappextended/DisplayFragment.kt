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
    private var imageViewModel: ImageViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_display, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)
        imageViewModel!!.getImage().observe(requireActivity(), {})
        imageViewModel!!.getText().observe(requireActivity(), {})
    }

    fun image(position: Int){
        imageView = layout.findViewById(R.id.imageView)
        textView = layout.findViewById(R.id.textView)

        imageView.setImageResource(position)
        textView.resources.getStringArray(position)
    }
}
