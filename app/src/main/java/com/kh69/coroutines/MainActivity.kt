package com.kh69.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                var ans1:String? = null
                var ans2:String? = null
                val jb1 = launch { ans1 = networkCall1() }
                val jb2 = launch { ans2 = networkCall2() }
                jb1.join()
                jb2.join()
                Log.d(TAG, "Request took $ans1 milliseconds" )
                Log.d(TAG, "Request took $ans2 milliseconds" )
            }
            Log.d(TAG, "Request took $time milliseconds" )
        }
    }
    suspend fun networkCall1():String{
        delay(3000L)
        return "Answer 1"
    }
    suspend fun networkCall2():String{
        delay(3000L)
        return "Answer 2"
    }
}


