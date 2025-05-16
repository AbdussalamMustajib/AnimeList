package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("COBALIFECYCLE", "Lifecycyle OnCreated")

        val buttonDetail = findViewById<Button>(R.id.button)
        buttonDetail.setOnClickListener {
            startActivity(Intent(this, ImplicitIntentActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("COBALIFECYCLE", "Lifecycyle OnStart")
    }

    override fun onPause() {
        super.onPause()

        Log.i("COBALIFECYCLE", "Lifecycyle OnPause")
    }

    override fun onPostResume() {
        super.onPostResume()

        Log.i("COBALIFECYCLE", "Lifecycyle OnResume")
    }

    override fun onStop() {
        super.onStop()

        Log.i("COBALIFECYCLE", "Lifecycyle OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("COBALIFECYCLE", "Lifecycyle OnDestroy")
    }
}