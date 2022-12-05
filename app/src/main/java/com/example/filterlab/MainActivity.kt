package com.example.filterlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val apiService = APIService.getService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->     //Нужно ли это?
            println("Handle $exception in CoroutineExceptionHandler")
        }
        val textEdit = findViewById<EditText>(R.id.textEditGet)
        val resultText = findViewById<TextView>(R.id.textView2)
        val button = findViewById<Button>(R.id.getButton)
        button.setOnClickListener() {
            lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                val service = apiService.getPostById(textEdit.text.toString().toInt())
                withContext(Dispatchers.Main) {
                    resultText.text = service?.title
                }
            }
        }
    }
}