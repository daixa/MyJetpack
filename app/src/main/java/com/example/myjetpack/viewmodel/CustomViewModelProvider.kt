package com.example.myjetpack.viewmodel

import android.content.Context
import com.example.myjetpack.db.RepositoryProvider
import com.example.myjetpack.viewmodel.factory.ShoeModelFactory
import com.example.myjetpack.db.repository.ShoeRepository

/**
 * ViewModel提供者
 */
object CustomViewModelProvider {

//    fun providerRegisterModel(context: Context): RegisterModelFactory {
//        val repository: UserRepository = RepositoryProvider.providerUserRepository(context)
//        return RegisterModelFactory(repository)
//    }
//
//    fun providerLoginModel(context: Context): LoginModelFactory {
//        val repository: UserRepository = RepositoryProvider.providerUserRepository(context)
//        return LoginModelFactory(repository, context)
//    }

    fun providerShoeModel(context: Context): ShoeModelFactory {
        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        return ShoeModelFactory(repository)
    }

//    fun providerFavouriteModel(context: Context): FavouriteModelFactory {
//        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
//        val userId:Long = AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
//        return FavouriteModelFactory(repository,userId)
//    }
//
//    fun providerMeModel(context: Context):MeModelFactory{
//        val repository:UserRepository = RepositoryProvider.providerUserRepository(context)
//        return MeModelFactory(repository)
//    }
//
//    /**
//     * @shoeId 鞋子的Id
//     * @userId 用户的Id
//     */
//    fun providerDetailModel(context: Context, shoeId: Long, userId: Long): FavouriteShoeModelFactory {
//        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
//        val favShoeRepository: FavouriteShoeRepository = RepositoryProvider.providerFavouriteShoeRepository(context)
//        return FavouriteShoeModelFactory(repository, favShoeRepository, shoeId, userId)
//    }
}