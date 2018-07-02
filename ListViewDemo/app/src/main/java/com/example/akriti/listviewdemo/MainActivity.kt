package com.example.akriti.listviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ListAdapter(getList())

        val dividerItemDecoration = DividerItemDecoration(recyclerView.getContext(),
                layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun getList(): ArrayList<Friend> {
        var list : ArrayList<Friend> = ArrayList<Friend>()

        list.add(Friend("Akriti1", "Sondhi1", "Hi!", "1:08 PM", "+91 1234123412"))
        list.add(Friend("Akriti2", "Sondhi2", "See you later.", "12:14 PM", "+91 1234123412"))
        list.add(Friend("Akriti3", "Sondhi3", "Good morning", "10:54 AM", "+91 1234123412"))
        list.add(Friend("Akriti4", "Sondhi4", "What's the plan! :D", "6:40 AM", "+91 1234123412"))

        return list
    }
}
