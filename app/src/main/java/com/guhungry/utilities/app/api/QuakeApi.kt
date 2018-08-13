package com.guhungry.utilities.app.api

object QuakeApi {
    const val BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/"

    private const val BASE_PARAMS = "query?format=geojson"

    const val URL_LARGE_QUAKES = "$BASE_PARAMS&minmagnitude=5&limit=10"
}
