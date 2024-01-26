package com.example.currencyconverterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val egyption_pound = "Egyption Pound"
    private val amreican_dollar = "Amercan Dollar"
    private val AED = "AED"
    private val GBP = "GBP"
    private val Euro = "Euro"
    val myvalues = mapOf(
        amreican_dollar to 1.0,
        egyption_pound to 30.95,
        AED to 3.67,
        GBP to 0.74 ,
        Euro to 0.92
    )
    lateinit var DropDownMenu1 : AutoCompleteTextView
    lateinit var DropDownMenu2 : AutoCompleteTextView
    lateinit var amountEt : TextInputEditText
    lateinit var resultEt :TextInputEditText
    lateinit var convertbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniliazationviews()
        populated_drop_menu()
        convertbtn.setOnClickListener {

       Calculate_Result()

        }


    }
    private fun Calculate_Result()
    {

        val amount = amountEt.text.toString().toDoubleOrNull()
        val toValue = myvalues[DropDownMenu2.text.toString()]
        val fromValue = myvalues[DropDownMenu1.text.toString()]

        val resultText = if (amount != null && toValue != null && fromValue != null) {
            (amount * toValue / fromValue).toString()
        } else {
            "Invalid input or selected currencies."

        }

        resultEt.setText(resultText)

    }
    private fun populated_drop_menu()
    {
        val mycountrylist = listOf(egyption_pound,amreican_dollar,AED,GBP,Euro)
        val adpater = ArrayAdapter(this,R.layout.drop_down_menu,mycountrylist)
        DropDownMenu1.setAdapter(adpater)
        DropDownMenu2.setAdapter(adpater)
    }
    private fun iniliazationviews()
    {
        amountEt = findViewById(R.id.amount_Field)
        convertbtn  = findViewById(R.id.convert_button)
        resultEt  = findViewById(R.id.Result_field)
        DropDownMenu1 = findViewById(R.id.Auto_c1)
        DropDownMenu2 = findViewById(R.id.Auto_c2)
    }


}