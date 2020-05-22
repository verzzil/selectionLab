package com.example.android

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import java.io.Serializable

class Person : Serializable {
    private var name: String
    private var surname: String
    private var password: String
    private var email: String
    private var photo: Int


    constructor(name: String, surname: String, email: String, password: String, photo: Int) {
        this.name = name
        this.surname = surname
        this.email = email
        this.photo = photo
        this.password = password
    }

    fun getName(): String {
        return this.name
    }
    fun getSurname(): String {
        return this.surname
    }
    fun getEmail(): String {
        return this.email
    }
    fun getPhoto(): Int {
        return this.photo
    }
    fun getPassword(): String {
        return this.password
    }
    fun getFullName(): String {
        return this.surname+" "+this.name
    }
    fun setPhoto() {

    }
}