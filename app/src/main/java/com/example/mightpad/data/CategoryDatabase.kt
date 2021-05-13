package com.example.mightpad.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Category::class], version = 1)
abstract class CategoryDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao

    class Callback
}