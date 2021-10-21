package edu.temple.imageviewerappextended

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
   private lateinit var imageItems: Array<ImageObject>
   private var imageViewModel: ImageViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)
        recycler = layout.findViewById(R.id.recyclerView)
        recycler.layoutManager = GridLayoutManager(requireContext(), 3)
        imageItems = getImages()

        imageViewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)

        val onClickListener = View.OnClickListener {
            val itemsPosition = recycler.getChildAdapterPosition(it)

            imageViewModel!!.setImage(imageItems[itemsPosition].id)
            imageViewModel!!.setText(imageItems[itemsPosition].description)
        }

        recycler.adapter = ImageAdapter(imageItems, onClickListener)

        return layout
    }

    private fun getImages(): Array<ImageObject>{
        return arrayOf(ImageObject(R.drawable.stalker, "Always Watching"),
            ImageObject(R.drawable.cuddles, "Cuddle Time!"),
            ImageObject(R.drawable.food_prep, "Dinner Time"),
            ImageObject(R.drawable.hide_n_seek, "Hide and Seek"),
            ImageObject( R.drawable.laundry, "Laundry Day"),
            ImageObject(R.drawable.microwave, "Spinning Around"),
            ImageObject(R.drawable.shocked, "Contemplating Life"),
            ImageObject( R.drawable.sleepy, "Taking a Nap"),
            ImageObject(R.drawable.tunnel, "In a Tunnel"),
            ImageObject( R.drawable.worker, "Hard at Work"),
        )
    }

    companion object {
         fun newInstance() = SelectionFragment().apply {
         }
    }

    interface Image{
        fun imageSelected(position: Int)
    }
}