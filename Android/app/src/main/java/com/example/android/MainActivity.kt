package com.example.android

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences
    private val APP_PREFERENCES = "usersettings"
    private var isLogged = false

    lateinit var passwordInput: EditText
    lateinit var emailInput: EditText
    lateinit var sendForm: Button
    var users = mutableSetOf<Person>()

    var albert = Person("Albert","Khannanov","xannanov.albert@mail.ru",
        "Rooo0t",R.drawable.alba)
    var yasmina = Person("Yasmina","Khannanova","yas@yandex.com",
        "Yaaa7s",R.drawable.yas)
    // было бы побольше времени, то всё это сделал через базы данных
    // и сделал бы ещё категории пользователей(Админ, юзер и тд)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.addAll(listOf(albert, yasmina))

        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        passwordInput = findViewById(R.id.passwordInput)
        emailInput = findViewById(R.id.emailInput)
        sendForm = findViewById(R.id.sendForm)
//        registr = findViewById(R.id.registr)

        emailInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(validatorEmail(emailInput.text.toString())) {
                    emailInput.setTextColor(getResources().getColor(R.color.black))
                }
                else {
                    emailInput.setTextColor(getResources().getColor(R.color.red))
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(!validatorPassword(passwordInput.text.toString())) {
                    passwordInput.setTextColor(getResources().getColor(R.color.red))
                }
                else {
                    passwordInput.setTextColor(getResources().getColor(R.color.black))
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        sendForm.setOnClickListener {
            if(validatorEmail(emailInput.text.toString()) &&
                validatorPassword(passwordInput.text.toString())) {
                var user = hasUser(emailInput.text.toString(), passwordInput.text.toString())
                if(user != null) {
                    isLogged = true
                    createUserProfile(user)
                }
                else {
                    val toast = Toast.makeText(applicationContext, "Такого пользователя нет",
                        Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            else {
                val toast = Toast.makeText(applicationContext, "Введите корректные данные",
                                            Toast.LENGTH_SHORT)
                toast.show()
            }
        }
//        registr.setOnClickListener {
//            val intent = Intent(this, RegistrActivity::class.java)
//            startActivity(intent)
//        }



    }


    override fun onResume() {
        super.onResume()

        if (pref.contains("logged")) {
            createUserProfile(pref.getString("name","").toString(),pref.getString("surname","").toString(),
                pref.getString("email","").toString(),pref.getString("password","").toString(),
                pref.getInt("photo",0))
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
    fun hasUser(email: String, password: String): Person? {
        for(user in users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) return user
        }
        return null
    }
    fun createUserProfile(user: Person) {
        val editor = pref.edit()
        editor.putBoolean("logged",isLogged)
        editor.putString("name",user.getName())
        editor.putString("surname",user.getSurname())
        editor.putString("email",user.getEmail())
        editor.putString("password",user.getPassword())
        editor.putInt("photo",user.getPhoto())
        editor.apply()
        val intent = Intent(this, UserActivity::class.java).apply {
            putExtra("userInfo",user)
        }
        startActivity(intent)
    }
    fun createUserProfile(name: String, surname: String, email: String, password: String, photo: Int) {
        var nuser = Person(name,surname,email,password,photo)
        val intent = Intent(this, UserActivity::class.java).apply {
            putExtra("userInfo",nuser)
        }
        startActivity(intent)
    }
}

