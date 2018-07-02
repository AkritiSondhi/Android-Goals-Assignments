package com.example.akriti.intentdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var openFragment : Button = findViewById(R.id.openFragment)
        openFragment.setOnClickListener {
            try {
                val bundle = Bundle()
                bundle.putString("Message", "Called from Main Activity")
                val newFragment = FirstFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container, newFragment)
                transaction.commit()
                newFragment.arguments = bundle
                openFragment.isActivated = false
                openFragment.visibility = View.INVISIBLE
            } catch (e: Exception) {
                Log.d("Error", e.localizedMessage)
            }

        };
    }
}
