package com.example.mightpad.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mightpad.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Category::class], version = 1)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    class CallBack @Inject constructor(
        private val database: Provider<CategoryDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().categoryDao()

            applicationScope.launch {
                dao.insert(Category(name = "1"))
                dao.insert(Category(name = "2"))
                dao.insert(Category(name = "3"))
            }

        }
    }
}