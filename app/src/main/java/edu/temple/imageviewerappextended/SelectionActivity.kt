package edu.temple.imageviewerappextended

import ImageAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        title = "Chet the Cat"

        val items = getImages()
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        recycler.layoutManager = GridLayoutManager(this, 3)
        val displayActivityIntent = Intent(this, DisplayActivity::class.java)

        val onClickListener = View.OnClickListener {
            val itemPosition = recycler.getChildAdapterPosition(it)

            displayActivityIntent.putExtra("ID", items[itemPosition].id)
            displayActivityIntent.putExtra("description", items[itemPosition].desc)

            startActivity(displayActivityIntent)
        }
        recycler.adapter = ImageAdapter(items, onClickListener)
    }
    private fun getImages(): Array<ImageObject>{
        return arrayOf(ImageObject("Always Watching", R.drawable.stalker),
            ImageObject("Feeling Cuddly", R.drawable.cuddles),
            ImageObject("Making Dinner", R.drawable.food_prep),
            ImageObject("Hide n' Seek", R.drawable.hide_n_seek),
            ImageObject("Laundry Day", R.drawable.laundry),
            ImageObject("Spinning Around", R.drawable.microwave),
            ImageObject("Contemplating Life", R.drawable.shocked),
            ImageObject("Nap Time", R.drawable.sleepy),
            ImageObject("Just Tunnel on Through", R.drawable.tunnel),
            ImageObject("Hard at Work", R.drawable.worker),
        )
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main activity state", "onStart() fired")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main activity state", "onResume() fired")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main activity state", "onPause() fired")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main activity state", "onStop() fired")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main activity state", "onDestroy() fired")
    }

}