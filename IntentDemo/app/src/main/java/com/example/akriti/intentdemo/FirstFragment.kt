package com.example.akriti.intentdemo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FirstFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    private var addNumbersButton: Button? = null
    private var openNextFragment: Button? = null
    private var openNextActivity: Button? = null
    private var rootView: View? = null
    private var number1: EditText? = null
    private var number2: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_first, container, false)
        setUpView()
        val messageText = arguments!!.getString("Message")
        val fragmentAText = rootView!!.findViewById<TextView>(R.id.fragmentAText)
        fragmentAText.append(" " + messageText!!)
        Toast.makeText(context, messageText, Toast.LENGTH_SHORT).show()
        return rootView
    }

    private fun setUpView() {
        addNumbersButton = rootView!!.findViewById<Button>(R.id.addNumbersButton)
        openNextFragment = rootView!!.findViewById<Button>(R.id.openNextFragment)
        openNextActivity = rootView!!.findViewById<Button>(R.id.openNextActivity)
        number1 = rootView!!.findViewById<EditText>(R.id.number1)
        number2 = rootView!!.findViewById<EditText>(R.id.number2)

        addNumbersButton!!.setOnClickListener({
            if (number1!!.text.toString().isEmpty()) {
                number1!!.error = "Please enter a number"
            }
            if (number2!!.text.toString().isEmpty()) {
                number2!!.error = "Please enter a number"
            }
            val numberOne = Integer.parseInt(number1!!.text.toString())
            val numberTwo = Integer.parseInt(number2!!.text.toString())

            Toast.makeText(activity,"The sum is "+(numberOne + numberTwo),Toast.LENGTH_LONG).show();
        })

        openNextFragment!!.setOnClickListener({
            try {
                val bundle = Bundle()
                bundle.putString("Message", "Called From Fragment A")
                val secondFragment = SecondFragment()
                val transaction = activity!!.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, secondFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                secondFragment.arguments = bundle
            } catch (e: Exception) {
                Log.v("Error", e.localizedMessage)
            }
        })

        openNextActivity!!.setOnClickListener({
            if (number1!!.text.toString().isEmpty()) {
                Toast.makeText(activity, "Please enter a number", Toast.LENGTH_SHORT).show();
            }
            else if (number2!!.text.toString().isEmpty()) {
                Toast.makeText(activity, "Please enter a number", Toast.LENGTH_SHORT).show();
            }
            else {
                val numberOne = Integer.parseInt(number1!!.text.toString())
                val numberTwo = Integer.parseInt(number2!!.text.toString())

                var intent = Intent(activity, ThirdActivity::class.java)
                intent.putExtra("num1", numberOne)
                intent.putExtra("num2", numberTwo)

                startActivity(intent)
            }
        })
    }
}
