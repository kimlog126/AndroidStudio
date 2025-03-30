package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivitySetBinding
import com.google.android.material.snackbar.Snackbar

class SetActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySetBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonResult.setOnClickListener {


            val height: Int = binding.height.text.toString().toInt()
            val weight: Int = binding.weight.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)  // 신장 값 전달
            intent.putExtra("weight", weight)  // 체중 값 전달
            startActivity(intent)  // ResultActivity 시작
        }
    }
}