package com.example.mightpad.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [Category::class], version = 1)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    class CallBack @Inject() constructor(
        private val database: Provider<CategoryDatabase>,
        @ApplicationScope private val applicationContext: CoroutineScope
    )
}