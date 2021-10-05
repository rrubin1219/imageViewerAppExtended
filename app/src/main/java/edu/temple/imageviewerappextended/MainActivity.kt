package edu.temple.imageviewerappextended

import ImageAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = getImages()

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val image = findViewById<ImageView>(R.id.imageView)
        val text = findViewById<TextView>(R.id.textView)

        recycler.layoutManager = GridLayoutManager(this, 3)

        val onClickListener = View.OnClickListener {
            val itemPosition = recycler.getChildAdapterPosition(it)
            image.setImageResource(items[itemPosition].resourceId)
            text.text = items[itemPosition].desc
        }
        recycler.adapter = ImageAdapter(items, onClickListener)
    }
    private fun getImages(): Array<ImageObject>{
        return arrayOf(ImageObject("I always feel like somebody's watching me", R.drawable.stalker),
            ImageObject("Feeling Cuddly", R.drawable.cuddles),
            ImageObject("Making Dinner", R.drawable.food_prep),
            ImageObject("Hide n' Seek", R.drawable.hide_n_seek),
            ImageObject("Laundry Day", R.drawable.laundry),
            ImageObject("Things are Heating Up", R.drawable.microwave),
            ImageObject("Contemplating Life", R.drawable.shocked),
            ImageObject("It's Bed Time", R.drawable.sleepy),
            ImageObject("Just Tunnel on Through", R.drawable.tunnel),
            ImageObject("Hard at Work", R.drawable.worker),
        )
    }

}