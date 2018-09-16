package com.kitopham.stackoverflowusers.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kitopham.stackoverflowusers.Services.APIProvider
import com.kitopham.stackoverflowusers.Models.Users
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private var data : MutableLiveData<Users>? = null

    fun getNames() : MutableLiveData<Users>{

        if (data == null){
            data = MutableLiveData()
            loadNames()
        }
        return data?.let{it} ?: MutableLiveData()
    }
    private fun loadNames(){
        val observer = APIProvider.apiService.users
        observer
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user ->
                        data?.let{
                            it.value = user
                    }
                })
    }
}
