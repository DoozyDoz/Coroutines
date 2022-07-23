package com.kh69.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val networkCallAnswer = doNetworkCall()
            withContext(Dispatchers.Main){
                tv_dummy.text = networkCallAnswer
            }
        }
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }


}