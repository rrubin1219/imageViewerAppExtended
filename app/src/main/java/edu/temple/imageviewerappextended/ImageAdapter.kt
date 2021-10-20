package edu.temple.imageviewerappextended

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (_items : Array<ImageObject>, _ocl : View.OnClickListener) : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    private val items = _items
    private val ocl = _ocl

    class ViewHolder(_view: ImageView, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val imageView = _view.apply { setOnClickListener(ocl) }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(250, 300) }, ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(items[position].id)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}