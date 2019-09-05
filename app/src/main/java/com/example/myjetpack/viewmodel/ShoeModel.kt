package com.example.myjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myjetpack.common.createPagerList
import com.example.myjetpack.db.data.Shoe
import com.example.myjetpack.db.datasource.CustomPageDataSourceFactory
import com.example.myjetpack.db.repository.ShoeRepository

class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {

    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

    // 鞋子集合的观察类
    val shoes: LiveData<PagedList<Shoe>> = brand.switchMap {
        // Room数据库查询，只要知道返回的是LiveData<List<Shoe>>即可
        if (it == ALL) {
            // LivePagedListBuilder<Int,Shoe>( shoeRepository.getAllShoes(),PagedList.Config.Builder()
            LivePagedListBuilder<Int, Shoe>(
                CustomPageDataSourceFactory(shoeRepository) // DataSourceFactory
                , PagedList.Config.Builder()
                    .setPageSize(10) // 分页加载的数量
                    .setEnablePlaceholders(false) // 当item为null是否使用PlaceHolder展示
                    .setInitialLoadSizeHint(10) // 预加载的数量
                    .build()
            ).build()
            //shoeRepository.getAllShoes()
        } else {
            val array: Array<String> =
                when (it) {
                    NIKE -> arrayOf("Nike", "Air Jordan")
                    ADIDAS -> arrayOf("Adidas")
                    else -> arrayOf(
                        "Converse", "UA"
                        , "ANTA"
                    )
                }
            shoeRepository.getShoesByBrand(array)
                .createPagerList(6, 6)
        }
    }

    companion object {
        public const val ALL = "所有"
        public const val NIKE = "Nike"
        public const val ADIDAS = "Adidas"
        public const val OTHER = "other"
    }
}