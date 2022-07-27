package com.kh69.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = CoroutineExceptionHandler{_,throwable->
            Log.d(TAG, "Caught exception $throwable")
        }

        GlobalScope.launch(handler){
            delay(5000L)
            throw Exception("Error")
        }
    }
}


