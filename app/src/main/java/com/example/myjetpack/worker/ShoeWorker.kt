package com.example.myjetpack.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myjetpack.db.RepositoryProvider
import com.example.myjetpack.db.data.Shoe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

class ShoeWorker(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {

    override val coroutineContext: CoroutineDispatcher
        get() = Dispatchers.IO

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open("shoes.json").use {
                JsonReader(it.reader()).use {
                    val shoeType = object : TypeToken<List<Shoe>>() {}.type
                    val shoeList: List<Shoe> = Gson().fromJson(it, shoeType)

                    val shoeDao = RepositoryProvider.providerShoeRepository(applicationContext)
                    shoeDao.insertShoes(shoeList)
                    for (i in 0..2) {
                        for (shoe in shoeList) {
                            shoe.id += shoeList.size
                        }
                        shoeDao.insertShoes(shoeList)
                    }
                    Result.success()
                }

            }
        } catch (ex: java.lang.Exception) {
            Result.failure()
        }
    }
}