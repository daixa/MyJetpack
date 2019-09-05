package com.example.myjetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myjetpack.db.dao.FavouriteShoeDao
import com.example.myjetpack.db.dao.ShoeDao
import com.example.myjetpack.db.dao.UserDao
import com.example.myjetpack.db.data.FavouriteShoe
import com.example.myjetpack.db.data.Shoe
import com.example.myjetpack.db.data.User
import com.example.myjetpack.worker.ShoeWorker

@Database(entities = [User::class, Shoe::class, FavouriteShoe::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun shoeDao(): ShoeDao

    abstract fun favouriteShoeDao(): FavouriteShoeDao

    companion object {
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatBase(context).also { instance = it }
            }
        }

        private fun buildDatBase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, "myjetpack-database")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // 读取鞋的集合
                        val request = OneTimeWorkRequestBuilder<ShoeWorker>().build()
                        WorkManager.getInstance().enqueue(request)
                    }
                }).build()
        }
    }
}