package com.guhungry.utilities.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ViewModelViewModel : ViewModel() {
    private val disposables = CompositeDisposable()
    var observable = Observable.range(1, 10)
            .delay(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .toList()
            .observeOn(AndroidSchedulers.mainThread())
    var ints: MutableLiveData<List<Int>> = MutableLiveData()

    fun loadData() {
        disposables.add(
                observable.subscribe { items, _ -> ints.postValue(items) }
        )
    }

    override fun onCleared() {
        super.onCleared()

        if (!disposables.isDisposed) disposables.dispose()
    }
}