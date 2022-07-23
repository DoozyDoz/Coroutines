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

        Log.d(TAG, "Before RunBlocking")
        runBlocking {
            Log.d(TAG, "Before delay RunBlocking")
            delay(5000L)
            Log.d(TAG, "After delay RunBlocking")
        }
        Log.d(TAG, "After RunBlocking")


    }
}


