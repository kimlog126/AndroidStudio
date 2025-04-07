package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExamActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var examAdapter: ExamAdapter
    private lateinit var examList: ArrayList<Exam>
    private lateinit var addButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)

        recyclerView = findViewById(R.id.recyclerView)
        addButton = findViewById(R.id.addButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        examList = ArrayList()
        prepareExamData()

        examAdapter = ExamAdapter(examList)
        recyclerView.adapter = examAdapter

        addButton.setOnClickListener {
            examList.add(Exam("", "", ""))
            examAdapter.notifyItemInserted(examList.size - 1)
        }
    }


    private fun prepareExamData() {
        // 이미지의 예시 데이터 추가
        examList.add(Exam("First Exam", "2025.03.15", "최선을 다하자!!"))
        examList.add(Exam("Midterm Exam", "2025.05.10", "재수강 할까?"))
        examList.add(Exam("Final Exam", "2025.06.15", "내가 제일 마지막에 끝낼듯..."))
    }
}