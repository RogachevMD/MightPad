package com.example.mightpad.ui.category

import androidx.lifecycle.*
import com.example.mightpad.data.CategoryDao
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    private val categoryDao: CategoryDao,
):ViewModel(){
}