package com.wang.roomdemo

import android.util.Log
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Author: wangxiaojie6
 * Date: 2018/4/4
 */
abstract class WSubscriber<T> : DisposableSubscriber<T>() {

    override fun onComplete() {
//        dispose()
    }

    override fun onNext(t: T) {
        try {
            success(t)
        } catch (e: NullPointerException) {
            Log.e("Error", e.message, e)
        }
    }

    override fun onError(t: Throwable) {
        Log.e("Error", t.message, t)
        try {
            error(t.message)
        } catch (e: NullPointerException) {
            Log.e("Error", e.message, e)
        }
    }

    abstract fun success(t: T)

    abstract fun error(error: String?)
}