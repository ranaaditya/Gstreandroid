package com.ranaaditya.gstreandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    external fun nativeGetGStreamerInfo(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        try {
            GStreamer.init(this@MainActivity)
        } catch (e: Exception) {
            Log.d("FUNCTION TEST", nativeGetGStreamerInfo())

            //Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()

            Log.d("ERROR MESSAGE", e.message.toString())
            return
        }

        version_string.text = "Welcome to " + nativeGetGStreamerInfo() + " !"
    }

    init {
        System.loadLibrary("gstreamer_android")
        System.loadLibrary("gsrteandroid")
    }

}