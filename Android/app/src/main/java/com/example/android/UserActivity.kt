package com.example.android


import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences
    private val APP_PREFERENCES = "usersettings"

    lateinit var photo: ImageView
    lateinit var email: TextView
    lateinit var fullname: TextView
    lateinit var user: Person
    lateinit var exit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        user = intent.getSerializableExtra("userInfo") as Person
        photo = findViewById(R.id.photo)
        email = findViewById(R.id.email)
        fullname = findViewById(R.id.fullname)
        exit = findViewById(R.id.exit)

        fullname.setText(user.getFullName())
        photo.setImageBitmap(BitmapFactory.decodeResource(this.resources, user.getPhoto()))
        email.setText(user.getEmail())

        exit.setOnClickListener {
            toStartActivity()
        }

    }

    override fun onBackPressed() {
        toStartActivity()
    }

    private fun toStartActivity() {
        pref.edit().clear().apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}