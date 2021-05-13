package com.example.mightpad.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat


@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val date: Long = System.currentTimeMillis(),
    val description: String

) : Parcelable {
    val createdDateFormat: String
        get() = DateFormat
            .getDateTimeInstance().format(date)
}
