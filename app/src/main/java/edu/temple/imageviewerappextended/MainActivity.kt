package edu.temple.imageviewerappextended

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SelectionFragment.Image{
    private lateinit var selectionFragment: SelectionFragment
    private lateinit var displayFragment: DisplayFragment

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

    override fun imageSelected(position: Int) {
        displayFragment.image(position)
    }

}