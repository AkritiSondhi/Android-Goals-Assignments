package com.example.akriti.lifecycledemoapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.google).setOnClickListener {
            val uris = Uri.parse("https://www.google.com")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intents)
        }

        findViewById<Button>(R.id.secondActivity).setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "Called on Activity Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "Called on Activity Resume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "Called on Activity Destroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "Called on Activity Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "Called on Activity Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "Called on Activity Stop")
    }
}
