package com.guhungry.utilities

import com.guhungry.utilities.app.api.QuakeApi
import com.guhungry.utilities.models.QuakeListResult
import io.reactivex.Observable
import retrofit2.http.GET

interface QuakeService {
    @GET(QuakeApi.URL_LARGE_QUAKES)
    fun getLargeQuakes(): Observable<QuakeListResult>
}