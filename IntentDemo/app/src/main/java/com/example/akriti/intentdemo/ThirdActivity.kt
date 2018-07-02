package com.example.akriti.intentdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var numOne = intent.getIntExtra("num1", 0)
        var numTwo = intent.getIntExtra("num2", 0)

        addNumbers(numOne, numTwo)
    }
    fun addNumbers(firstNo: Int, secondNo: Int) {
        var sum = firstNo + secondNo;
        Toast.makeText(this,"The sum is " + sum, Toast.LENGTH_LONG).show();
        findViewById<TextView>(R.id.sum).setText("The sum is " + sum)
    }

}
