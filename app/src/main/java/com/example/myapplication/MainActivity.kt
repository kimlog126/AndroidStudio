package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.login.setOnClickListener{
            val inputid = binding.id.text.toString()
            val inputPassword = binding.password.text.toString()

            Snackbar.make(binding.root, "ID: $inputid\nPassword: $inputPassword", Snackbar.LENGTH_LONG).show()
        }

    }
}