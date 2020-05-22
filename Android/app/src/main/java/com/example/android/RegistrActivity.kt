package com.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.graphics.Bitmap
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.net.toFile
import java.io.File

class RegistrActivity : AppCompatActivity() {


    val GALLERY_REQUEST = 1
    lateinit var loadImage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loadImage = findViewById(R.id.loadImage)
        loadImage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val photoPickerIntent = Intent(Intent.ACTION_PICK)
                photoPickerIntent.type = "image/*"
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST)
            }
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)

        var bitmap: Bitmap? = null
        val imageView = findViewById(R.id.ava) as ImageView

        when (requestCode) {
            GALLERY_REQUEST -> if (resultCode == RESULT_OK) {
                val selectedImage = imageReturnedIntent!!.data

//                val img = ImageIO.read(first)
//                val file = File("src\\CreateFile\\down.jpg")
//                bitmap = BitmapFactory.
            }
        }
    }

}
