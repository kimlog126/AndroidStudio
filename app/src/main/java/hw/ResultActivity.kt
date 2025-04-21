package hw

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        var bmi = weight / (height / 100.0).pow(2.0)
        binding.resultNum.text = "%.1f".format(bmi)

        when {
            bmi >= 35 -> binding.resultText.text = "3단계 비만"
            bmi >= 30 -> binding.resultText.text = "2단계 비만"
            bmi >= 25 -> binding.resultText.text = "1단계 비만"
            bmi >= 23 -> binding.resultText.text = "과체중"
            bmi >= 18.5 -> binding.resultText.text = "정상"
            else -> binding.resultText.text = "저체중"
        }

        when {
            bmi >= 23 -> binding.resultImage.setImageResource(R.drawable.dissapointed)
            bmi >= 18.5 -> binding.resultImage.setImageResource(R.drawable.happy)
            else -> binding.resultImage.setImageResource(R.drawable.cry)
        }

        when {
            bmi >= 23 -> binding.resultNum.setTextColor(Color.RED)
            bmi >= 18.5 -> binding.resultNum.setTextColor(Color.GREEN)
            else -> binding.resultNum.setTextColor(Color.BLUE)
        }

        binding.reset.setOnClickListener {
            val intent = Intent(this, SetActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}