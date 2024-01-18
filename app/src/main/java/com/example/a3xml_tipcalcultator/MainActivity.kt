package com.example.a3xml_tipcalcultator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a3xml_tipcalcultator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    //get options and calculate tip
    private fun calculateTip() {
        //get the text from cost of service
        val costOfService = binding.costOfService.text.toString().toDouble()

        //get percentage to calculate tip
        //find radio group(tip_options)-> get id for checkedRadioButton id to check percentage
        val selectedId = binding.tipOptions.checkedRadioButtonId

        //convert selectedId to selectedPercentage
        val tipPercentage = when (selectedId) {
            R.id.option_fifteen_percent -> 0.15
            R.id.option_eighteen_percent -> 0.18
            else -> 0.20
        }

        var tip = costOfService * tipPercentage //var because user might round up tip

        val roundUp = binding.roundUpTip.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }

        val currencyTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, currencyTip)

    }
}