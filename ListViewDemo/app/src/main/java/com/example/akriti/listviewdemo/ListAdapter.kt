package com.example.akriti.listviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Akriti on 7/2/2018.
 */

class ListAdapter(private val myDataset: ArrayList<Friend>) :
        RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListAdapter.ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false) as View
        // set the view's size, margins, paddings and layout parameters

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        var friend : Friend = myDataset.get(position)
        holder.view.findViewById<TextView>(R.id.name).setText(friend.fname + " " + friend.lname)
        holder.view.findViewById<TextView>(R.id.last_msg).setText("Last message: " + friend.last_msg)
        holder.view.findViewById<TextView>(R.id.time).setText("Last seen: " + friend.time)
        holder.view.findViewById<TextView>(R.id.contact).setText("" + friend.contact)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}