package com.riyaldi.temperatureconverter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val c = "Celcius"
        const val f = "Fahrenheit"
        const val k = "Kelvin"
        const val r = "Reaumur"
    }

    private var temp1 = c
    private var temp2 = f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        btTempClick()
    }

    private fun initView() {
        btTemp1.text = temp1
        btTemp2.text = temp2
        button.setOnClickListener {
            countTemp()
        }
    }

    private fun btTempClick() {
        btTemp1.setOnClickListener {
            buildDialog(1)
        }

        btTemp2.setOnClickListener {
            buildDialog(2)
        }
    }

    private fun buildDialog(tempNum : Int) {
        val singleItems = arrayOf(c, f, k, r)

        MaterialAlertDialogBuilder(this@MainActivity)
            .setTitle("Pilih salah satu!")
            .setItems(singleItems) { dialog, which ->
                if (tempNum == 1) {
                    temp1 = singleItems[which]
                    btTemp1.text = temp1
                } else {
                    temp2 = singleItems[which]
                    btTemp2.text = temp2
                }
            }
            .show()
    }

    private fun countTemp() {
        when {
            temp1 == c && temp2 == f -> {
                val value = ctof(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.setText(value)
            }
            temp1 == c && temp2 == r -> {
                val value = ctor(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.setText(value)
            }
            temp1 == c && temp2 == k -> {
//                ctok()
            }
            temp1 == f && temp2 == c -> {
//                ftoc()
            }
            temp1 == f && temp2 == r -> {
//                ftor()
            }
            temp1 == f && temp2 == k -> {
//                ftok()
            }
            temp1 == r && temp2 == c -> {
//                rtoc()
            }
            temp1 == r && temp2 == f -> {
//                rtof()
            }
            temp1 == r && temp2 == k -> {
//                rtok()
            }
            temp1 == k && temp2 == c -> {
//                ktoc()
            }
            temp1 == k && temp2 == f -> {
//                ktof()
            }
            temp1 == k && temp2 == r -> {
//                ktor()
            }
            else -> Toast.makeText(this, "Tidak dapat mengkonversi 2 temperatur yang sama", Toast.LENGTH_LONG).show()
        }
    }

    private fun ctof(c: Double): Double {
        val hasil = c * (9.0 / 5.0) + 32.0
        return hasil
    }

    private fun ctor(c: Double): Double {
        val hasil = c * (4.0 / 5.0)
        return hasil
    }
}