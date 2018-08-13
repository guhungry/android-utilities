package com.guhungry.utilities.app.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guhungry.utilities.NetworkUtils
import com.guhungry.utilities.QuakeService
import com.guhungry.utilities.R

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
    }

    private fun getQuakeService(): QuakeService {
        return NetworkUtils.getService(QuakeService::class.java, "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson")
    }
}
