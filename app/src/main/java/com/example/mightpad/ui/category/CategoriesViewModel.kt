package com.example.mightpad.ui.category

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.mightpad.data.CategoryDao
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    private val categoryDao: CategoryDao,
) : ViewModel() {


}