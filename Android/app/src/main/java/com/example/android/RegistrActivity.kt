package com.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.graphics.Bitmap
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toFile
import java.io.File

class RegistrActivity : AppCompatActivity() {


    val GALLERY_REQUEST = 1
    lateinit var loadImage: Button
    lateinit var register: Button
    private lateinit var pref: SharedPreferences
    private val APP_PREFERENCES = "usersettings"
    private var isLogged = false
    lateinit var rname: EditText
    lateinit var rsurname: EditText
    lateinit var remail: EditText
    lateinit var rpassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        loadImage = findViewById(R.id.loadImage)
        register = findViewById(R.id.register)
        rname = findViewById(R.id.rname)
        rsurname = findViewById(R.id.rsurname)
        remail = findViewById(R.id.remail)
        rpassword = findViewById(R.id.rpassword)


        register.setOnClickListener {

            if(rname.length() > 2 && rsurname.length() > 2 && validatorEmail(remail.text.toString()) &&
                    validatorPassword(rpassword.text.toString())) {
                val prefEdit = pref.edit()
                prefEdit.putString("name",rname.toString())
                prefEdit.putString("surname",rsurname.toString())
                prefEdit.putString("email",remail.toString())
                prefEdit.putString("password",rpassword.toString())
                prefEdit.putInt("photo",R.drawable.def)
                prefEdit.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else register.setText("a")
        }

    }

    fun validatorEmail(str: String): Boolean {
        return str.matches(Regex("""^.+@.+\..+$"""))
    }
    fun validatorPassword(str: String): Boolean {
        return Regex("[A-Z]").containsMatchIn(str) &&
                Regex("[a-z]").containsMatchIn(str) &&
                Regex("[0-9]").containsMatchIn(str) &&
                str.length >= 6
    }

}
