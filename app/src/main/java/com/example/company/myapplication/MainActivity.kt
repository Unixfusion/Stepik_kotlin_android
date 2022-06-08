package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Exception



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener(::calculate)
        subtr.setOnClickListener(::calculate)
        mul.setOnClickListener(::calculate)
        divide.setOnClickListener(::calculate)
    }

    fun calculate(v: View) {
        try {
            val a1 = arg1.text.toString().toInt()
            val a2 = arg2.text.toString().toInt()

            when (v) {
                add -> answer.text = "${a1 + a2}"
                subtr -> answer.text = "${a1 - a2}"
                mul -> answer.text = "${a1 * a2}"
                divide -> answer.text = "${a1 / a2}"
            }
        } catch (nfe: NumberFormatException) {
            answer.text = "Input Error"
        } catch (ae: ArithmeticException) {
            answer.text = "Div by zero"
        }
    }
}

