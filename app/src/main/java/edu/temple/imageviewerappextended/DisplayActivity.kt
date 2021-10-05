package edu.temple.imageviewerappextended

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


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