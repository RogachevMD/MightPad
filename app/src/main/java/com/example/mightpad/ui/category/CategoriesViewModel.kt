package com.example.mightpad.ui.category

import androidx.lifecycle.ViewModel
import com.example.mightpad.data.CategoryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoryDao: CategoryDao
) : ViewModel() {

    val searchQuery = MutableStateFlow("")

    val sortOrder = MutableStateFlow(SortOrder.BY_DATE)


    private val categoriesFlow = combine(
        searchQuery,
        sortOrder
    ) { query, sortOrder ->
        Pair(query, sortOrder)
    }.flatMapLatest { (query, sortOrder) ->
        categoryDao.getCategories(query, sortOrder)
    }
}

val categories = categoriesFlow.asLiveData()
}

enum class SortOrder {
    BY_NAME, BY_DATE
}