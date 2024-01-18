package com.example.a3xml_tipcalcultator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a3xml_tipcalcultator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{calculateTip()}
    }

    //get options and calculate tip
    private fun calculateTip() {
        TODO("Get options and calculate tip")
    }
}