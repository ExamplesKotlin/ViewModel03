package com.example.carajo.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carajo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSender.setOnClickListener {
            showView()
        }
    }

    fun showView(){
        val myIntent = Intent(this, SecondViewModelActivity::class.java)
        startActivity(myIntent)
    }
}