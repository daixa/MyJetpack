package com.example.myjetpack.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

object ToastUtils {
    var isShow: Boolean = true
    var mToast: Toast? = null

    fun controlShow(isShowToast: Boolean) {
        isShow = isShowToast
    }

    fun channelToast() {
        if (isShow && mToast != null) {
            mToast?.cancel()
        }
    }

    @SuppressLint("ShowToast")
    fun showShort(context: Context, msg: String) {
        if (isShow) {
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            } else {
                mToast?.setText(msg)
            }
            mToast?.show()
        }
    }

    @SuppressLint("ShowToast")
    fun showShort(context: Context, resId: Int) {
        if (isShow) {
            if (mToast == null) {
                mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT)
            } else {
                mToast?.setText(resId)
            }
            mToast?.show()
        }
    }

    @SuppressLint("ShowToast")
    fun showLong(context: Context, msg: String) {
        if (isShow) {
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
            } else {
                mToast?.setText(msg)
            }
            mToast?.show()
        }
    }

    @SuppressLint("ShowToast")
    fun showLong(context: Context, resId: Int) {
        if (isShow) {
            if (mToast == null) {
                mToast = Toast.makeText(context, resId, Toast.LENGTH_LONG)
            } else {
                mToast?.setText(resId)
            }
            mToast?.show()
        }
    }
}