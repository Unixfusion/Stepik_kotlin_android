package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.ArraySet
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Exception
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tempa: Data

        add.setOnClickListener {
            tempa = check(arg1.text.toString(), arg2.text.toString())
            setButtonResult(tempa, "add")
        }

        subtr.setOnClickListener {
            tempa = check(arg1.text.toString(), arg2.text.toString())
            setButtonResult(tempa, "subtr")
        }

        mul.setOnClickListener {
            tempa = check(arg1.text.toString(), arg2.text.toString())
            setButtonResult(tempa, "mul")
        }

        divide.setOnClickListener {
            tempa = check(arg1.text.toString(), arg2.text.toString())
            setButtonResult(tempa, "divide")
        }

    }

    fun plus(a: Int, b: Int): String {
        return (a + b).toString()
    }

    fun minus(a: Int, b: Int): String {
        return (a - b).toString()
    }

    fun multiply(a: Int, b: Int): String {
        return (a * b).toString()
    }

    fun divide(a: Int, b: Int): String {
        return (a / b).toString()
    }

    fun check(a: String?, b: String?): Data {
        var temp1 = -1
        var temp2 = -1
        var arg1 = ""
        var arg2 = ""
        var isError = false

    try {
        temp1 = a!!.toInt()
        arg1 = temp1.toString()
    } catch (e: Exception) {
        arg1 = "Input Error"
        isError = true
    }

    try {
        temp2 = b!!.toInt()
        arg2 = temp2.toString()
    } catch (e: Exception) {
        arg2 = "Input Error"
        isError = true
    }

    if (temp2 == 0) {
        isError = true
    }
    return Data(arg1, arg2, isError)
    }
    fun setButtonResult(input: Data, button: String) {
        if (input.isError) {
            if (input.a == "Input Error" || input.b == "Input Error") {
                answer.text = "Input Error"
            }
            else if (input.b.toInt() == 0) {
                answer.text = "Div by zero"
            }

        } else {
           answer.text = when (button) {
               "add" -> plus(input.a.toInt(), input.b.toInt())
               "subtr" -> minus(input.a.toInt(), input.b.toInt())
               "mul" -> multiply(input.a.toInt(), input.b.toInt())
               "divide" -> divide(input.a.toInt(), input.b.toInt())
               else -> { "Input Error" }
           }

        }

    }
}

