package edu.temple.imageviewerappextended

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SelectionFragment.Images {
    lateinit var selectionFragment: SelectionFragment
    lateinit var displayFragment: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = resources.getString(R.string.title)

        selectionFragment = SelectionFragment.newInstance()
        displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.selectionView, selectionFragment) //Adding Selection View
            .add(R.id.displayView, displayFragment) //Adding Display View
            .commit()



    }
    override fun image(position: Int) {
    }
}
/*

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
        val items = getImages()
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        recycler.layoutManager = GridLayoutManager(this, 3)
        //val displayActivityIntent = Intent(this, DisplayActivity::class.java)
        val array: Array<String> = resources.getStringArray(R.array.description)

        val onClickListener = View.OnClickListener {
            val itemPosition = recycler.getChildAdapterPosition(it)

            //displayActivityIntent.putExtra("ID", items[itemPosition].id)
            //displayActivityIntent.putExtra("description", array[itemPosition])

            //startActivity(displayActivityIntent)
        }

        recycler.adapter = ImageAdapter(items, onClickListener)
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

}*/

/*
val image = findViewById<ImageView>(R.id.imageView)
        val text = findViewById<TextView>(R.id.textView)

        val message = intent.getStringExtra("description")
        text.text = message

        val bundle = intent.extras
        val id = bundle?.getInt("ID")
        if (id != null) {
            image.setImageResource(id)
        }
        title = message
*/