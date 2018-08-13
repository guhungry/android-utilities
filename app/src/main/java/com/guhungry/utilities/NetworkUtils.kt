package com.guhungry.utilities

import io.reactivex.schedulers.Schedulers
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils {
    @JvmStatic
    fun <T> getService(service: Class<T>, baseUrl: String): T {
        return createRetrofit(baseUrl).create(service)
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(getConverter())
                .addCallAdapterFactory(getCallAdapter())
                .build();
    }

    private fun getConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    private fun getCallAdapter(): CallAdapter.Factory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }
}