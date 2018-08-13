package com.guhungry.utilities

import com.guhungry.utilities.models.QuakeListResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface QuakeService {
    @GET
    fun getTrends() : Observable<QuakeListResult>
}