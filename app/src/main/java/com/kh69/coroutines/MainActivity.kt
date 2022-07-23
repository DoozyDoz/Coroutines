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
            Log.d(TAG, "Starting thread is called : ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){
                tv_dummy.text = networkCallAnswer
                Log.d(TAG, "Setting text in thread called : ${Thread.currentThread().name}")
            }
        }
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }


}