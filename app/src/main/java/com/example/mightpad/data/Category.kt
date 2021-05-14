package com.example.mightpad.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import kotlinx.parcelize.Parcelize


@Entity(tableName = "category_table")
@Parcelize
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String = "",
    val created: Long = System.currentTimeMillis(),
    val description: String = ""

) : Parcelable {
    val createdDateFormat: String
        get() = DateFormat
            .getDateTimeInstance().format(created)
}
