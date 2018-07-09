package com.kitopham.stackoverflowusers.Services

import com.kitopham.stackoverflowusers.Models.Users
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


abstract class DataObserver : Observer<Users> {
    val user : Users? = null

    override fun onComplete() {

    }
    override fun onError(e: Throwable) {
    }

    override fun onNext(user : Users){
    }
    override fun onSubscribe(d: Disposable) {
    }

}