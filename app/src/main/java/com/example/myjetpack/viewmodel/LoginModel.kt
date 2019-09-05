package com.example.myjetpack.viewmodel

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.databinding.adapters.TextViewBindingAdapter
import com.example.myjetpack.common.ActivityUtils
import com.example.myjetpack.common.Constant
import com.example.myjetpack.common.listener.SimpleWatcher
import com.example.myjetpack.ui.activity.MainActivity
import com.example.myjetpack.utils.ToastUtils
import java.security.AccessControlContext

class LoginModel constructor(name: String, pwd: String, context: Context) {
    val n = ObservableField<String>(name)
    val p = ObservableField<String>(pwd)
    var context: Context = context

    //用户名改变回调通知
    fun onNameChanged(s: CharSequence) {
        n.set(s.toString())
    }

    //    密码改变回调通知
    fun onPwdChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        p.set(s.toString())
    }

    fun login() {
        if (n.get().equals(Constant.USER_NAME) && p.get().equals(Constant.USER_PWD)) {
            ToastUtils.showShort(context, "登陆成功")
            ActivityUtils.startMainActivity(context)
        }
    }

    // SimpleWatcher 是简化了的TextWatcher
    val nameWatcher = object : SimpleWatcher() {
        override fun afterTextChanged(p0: Editable?) {
            super.afterTextChanged(p0)
            n.set(p0.toString())
        }
    }


}