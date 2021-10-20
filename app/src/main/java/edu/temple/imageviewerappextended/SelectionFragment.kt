package edu.temple.imageviewerappextended

import ImageAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
   private lateinit var recycler: RecyclerView
   private lateinit var layout: View
   private lateinit var items: Array<ImageObject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {  }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)
        val imageViewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)

        recycler = layout.findViewById(R.id.recyclerView)
        items = getImages()

        val onClickListener = View.OnClickListener {
            val itemsPosition = recycler.getChildAdapterPosition(it)
            imageViewModel.setImage(items[itemsPosition].id)
        }

        recycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = ImageAdapter(items, onClickListener)
        }
        return layout
    }

    private fun getImages(): Array<ImageObject>{
        return arrayOf(ImageObject(R.drawable.stalker),
            ImageObject(R.drawable.cuddles),
            ImageObject(R.drawable.food_prep),
            ImageObject(R.drawable.hide_n_seek),
            ImageObject( R.drawable.laundry),
            ImageObject(R.drawable.microwave),
            ImageObject(R.drawable.shocked),
            ImageObject( R.drawable.sleepy),
            ImageObject(R.drawable.tunnel),
            ImageObject( R.drawable.worker),
        )
    }

    companion object {
         fun newInstance() = SelectionFragment().apply {
         }
    }

    interface Image{
        fun onImageSelected(position: Int)
    }
}