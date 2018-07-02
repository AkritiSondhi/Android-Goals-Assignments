package com.example.akriti.intentdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SecondFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        val strtext = arguments!!.getString("Message")
        val fragmentAText = rootView.findViewById<TextView>(R.id.fragmentBText)
        fragmentAText.append(" " + strtext!!)
        Toast.makeText(context, strtext, Toast.LENGTH_SHORT).show()
        return rootView
    }
}
