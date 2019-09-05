package com.example.myjetpack.db.datasource

import androidx.paging.DataSource
import com.example.myjetpack.db.data.Shoe
import com.example.myjetpack.db.repository.ShoeRepository

/**
 * 构建CustomPageDataSource的工厂
 */
class CustomPageDataSourceFactory(private val shoeRepository: ShoeRepository):DataSource.Factory<Int,Shoe>() {
    override fun create(): DataSource<Int, Shoe> {
        return CustomPageDataSource(shoeRepository)
    }
}