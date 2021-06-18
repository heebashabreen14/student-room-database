package com.example.roomdatabaseexample

import android.app.Application

class WordsApplication: Application(){

    private val database= WordDatabase.getDatabase(context = this)
    val repository= WordRepository(database.wordDao())
}