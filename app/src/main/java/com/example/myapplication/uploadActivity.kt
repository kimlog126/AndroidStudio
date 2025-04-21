package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityUploadBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database


class uploadActivity : AppCompatActivity() {
    private val binding by lazy { ActivityUploadBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonUpload.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val context = binding.editTextContext.text.toString()

            if (title.isNotEmpty() && context.isNotEmpty()) {
                val doc = DocModel(title, context)
                val database = Firebase.database
                val ref = database.getReference("data")
                ref.push().setValue(doc).addOnSuccessListener {
                    finish()
                }
            }
        }

    }
}