package com.wang.roomdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wang.roomdemo.mode.User

class MainActivity : AppCompatActivity(), MainActivityPresenter.IView {

    private lateinit var mPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainActivityPresenter(this, this)
//        mPresenter.add(40)
//        mPresenter.add(id = 38, age = 16)
//        mPresenter.add(1, lastName = "cong")
//        mPresenter.add(id = 25, age = 21)
//        mPresenter.add(10, firstName = "hu", lastName = "qiuye", age = 18)
//        mPresenter.add(8, firstName = "zhang", lastName = "san", age = 3)
//
//        mPresenter.addPhone(1, 40)
//        mPresenter.addPhone(3, 40, "16868682828")
//        mPresenter.addPhone(2, 38, "13819411655")
//        mPresenter.addPhone(4, null, "13838385438")
//
//        mPresenter.getAll()
//        mPresenter.getAllPhone()

//        mPresenter.deleteUser(99)

        mPresenter.getAllPhone()
//        mPresenter.getNoOwnerPhone()
        mPresenter.getPhoneByName("wang", "xiaojie")
    }

    override fun addSuccess(user: User) {
//        Log.d("test", user.toString())
//        mPresenter.getAll()
//        mPresenter.getAllPhone()
//        mPresenter.deleteUser(40)
    }

    override fun getAllSuccess(t: List<User>) {
        Log.d("test", t.toString())
    }

    override fun deleteSuccess(user: User) {
        mPresenter.getAll()
        mPresenter.getAllPhone()
    }
}
