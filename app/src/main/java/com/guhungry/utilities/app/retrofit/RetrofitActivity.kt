package com.guhungry.utilities.app.retrofit

import android.os.Bundle
import com.google.gson.Gson
import com.guhungry.utilities.NetworkUtils
import com.guhungry.utilities.QuakeService
import com.guhungry.utilities.R
import com.guhungry.utilities.app.api.QuakeApi
import com.guhungry.utilities.app.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*

class RetrofitActivity : BaseActivity() {
    private val service by lazy { getQuakeService() }
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
    }

    private fun getQuakeService(): QuakeService {
        return NetworkUtils.getService(QuakeService::class.java, QuakeApi.BASE_URL)
    }

    override fun onResume() {
        super.onResume()

        disposables.add(
                service.getLargeQuakes()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { response.text = Gson().toJson(it) }
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        if (!disposables.isDisposed) disposables.dispose()
    }
}
