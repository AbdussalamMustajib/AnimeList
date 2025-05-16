package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonTelp = findViewById<Button>(R.id.btn_telp)
        val buttonMapsApp = findViewById<Button>(R.id.btn_maps_app)
        val buttonMapsUrl = findViewById<Button>(R.id.btn_maps_url)
        val buttonCam = findViewById<Button>(R.id.btn_cam)
        val buttonWa = findViewById<Button>(R.id.btn_wa)

        buttonTelp.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:082230272067")
            startActivity(intent)
        }

        val latitude = -7.01821821
        val longitude = 9.01821821

        buttonMapsApp.setOnClickListener {
            val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Aplikasi Belum terinstall", Toast.LENGTH_SHORT).show()
            }
        }

        buttonMapsUrl.setOnClickListener {
            val url = "https://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        buttonCam.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        val etPhone = findViewById<EditText>(R.id.edt_phone)
        val etMsg = findViewById<EditText>(R.id.edt_phone)

        buttonWa.setOnClickListener {
            val phone = etPhone.text.toString()
            val message = etMsg.text.toString()

            val url = "https://wa.me/+62$phone?text=${Uri.encode(message)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            intent.setPackage("com.whatsapp")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "WhatsApp tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}