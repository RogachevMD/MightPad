package com.example.mightpad.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_table WHERE name LIKE '%' || :searchQuery || '%' ORDER BY created DESC")
    fun getCategories(searchQuery: String): Flow<List<Category>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)
}