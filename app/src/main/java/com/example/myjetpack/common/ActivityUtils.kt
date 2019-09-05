package com.example.myjetpack.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.myjetpack.ui.activity.MainActivity

object ActivityUtils {


    /**
     * @param clazz
     * @author max
     * @description 跳转到指定界面
     */
    fun goActivity(context: Context, clazz: Class<out Activity>) {
        goActivity(context, null, clazz)
    }

    /**
     * @param extras 携带的数据
     * @param clazz
     * @author max
     * @description 跳转到指定界面
     */
    private fun goActivity(context: Context, extras: Bundle?, clazz: Class<out Activity>) {
        val intent = Intent(context, clazz)
        if (extras != null) {
            intent.putExtras(extras)
        }
        context.startActivity(intent)
    }

    /**
     * @param clazz
     * @param requestCode
     * @author max
     * @description 跳转界面并得到返回值
     */
    fun goActivityForResult(context: Context, clazz: Class<out Activity>, requestCode: Int) {
        goActivityForResult(context, null, clazz, requestCode)
    }

    /**
     * @param clazz
     * @param requestCode
     * @author max
     * @description 跳转界面并得到返回值
     */
    private fun goActivityForResult(context: Context, extras: Bundle?, clazz: Class<out Activity>, requestCode: Int) {
        val intent = Intent(context, clazz)
        if (extras != null) {
            intent.putExtras(extras)
        }
        (context as Activity).startActivityForResult(intent, requestCode)
    }

    /**
     * 进入主页面
     */
    fun startMainActivity(context: Context) {
        goActivity(context, MainActivity::class.java)
    }
}