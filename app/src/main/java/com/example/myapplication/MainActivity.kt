package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val list = mutableListOf<DocModel>()
    private lateinit var adapter: DocAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = DocAdapter(list)
        binding.recyclerView.adapter = adapter

        getData()

        binding.buttonWrite.setOnClickListener {
            val intent = Intent(this, uploadActivity::class.java)
            startActivity(intent)
        }
    }

    fun getData() {
        val database = Firebase.database
        val ref = database.getReference("data")

        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                list.add(DocModel("제목1", "내용을 입력하세요."))

                for (dataModel in snapshot.children) {
                    val value = dataModel.getValue(DocModel::class.java)
                    value?.let { list.add(value) }
                }

                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("BoardListActivity", "onCancelled: ${error.toException()}")
            }
        }
        ref.addValueEventListener(postListener)
    }

}