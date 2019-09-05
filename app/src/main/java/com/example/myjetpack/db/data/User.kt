package com.example.myjetpack.db.data

import androidx.room.*

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "user_account") val account: String,
    @ColumnInfo(name = "user_pwd") val pwd: String,
    @ColumnInfo(name = "user_name") val name: String,
    @Embedded val address: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}