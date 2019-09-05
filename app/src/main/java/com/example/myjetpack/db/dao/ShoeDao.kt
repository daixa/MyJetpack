package com.example.myjetpack.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.myjetpack.db.data.Shoe

@Dao
interface ShoeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes: List<Shoe>)

    @Delete
    fun deleteShoe(shoe: Shoe)

    @Delete
    fun deleteShoes(shoes: List<Shoe>)

    @Update
    fun upateShoe(shoe: Shoe)

    @Update
    fun upateShoes(shoes: List<Shoe>)

    //查询一个
    @Query("SELECT * FROM shoe WHERE id= :id")
    fun findShoeById(id: Long): Shoe?

    //查询多个根据品牌查询
    @Query("SELECT * FROM shoe WHERE shoe_brand= :brand")
    fun findShoesByBrand(brand: String): List<Shoe>

    // 模糊查询 排序 同名鞋名查询鞋
    @Query("SELECT * FROM shoe WHERE shoe_name LIKE :name ORDER BY shoe_brand ASC")
    fun findShoesByName(name: String): List<Shoe>

    // 配合RxJava 通过Id查询单款鞋子
//    @Query("SELECT * FROM shoe WHERE id=:id")
//    fun findShoeByIdRx(id: Long): Flowable<Shoe>

    // 通过鞋子的范围寻找Index
    @Query("SELECT * FROM shoe WHERE id between :startIndex AND :endIndex ORDER BY id ASC")
    fun findShoesByIndexRange(startIndex: Long, endIndex: Long): List<Shoe>

    // 配合LiveData 返回所有的鞋子
    @Query("SELECT * FROM shoe")
    fun getAllShoesLD(): DataSource.Factory<Int, Shoe>
    //fun getAllShoesLD(): LiveData<List<Shoe>>

    // 配合LiveData 通过Id查询单款鞋子
    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeByIdLD(id: Long): LiveData<Shoe>


    /**
     * 通过品牌查询鞋子
     */
    @Query("SELECT * FROM shoe WHERE shoe_brand IN (:brand)")
    fun findShoesByBrandLD(brand: Array<String>): DataSource.Factory<Int, Shoe>
    //fun findShoesByBrandLD(brand: String): LiveData<List<Shoe>>

    // 根据收藏结合 查询用户喜欢的鞋的集合
    @Query(
        "SELECT shoe.id,shoe.shoe_name,shoe.shoe_description,shoe.shoe_price,shoe.shoe_brand,shoe.shoe_imgUrl " +
                "FROM shoe " +
                "INNER JOIN fav_shoe ON fav_shoe.shoe_id = shoe.id " +
                "WHERE fav_shoe.user_id = :userId"
    )
    fun findShoesByUserId(userId: Long): LiveData<List<Shoe>>
}