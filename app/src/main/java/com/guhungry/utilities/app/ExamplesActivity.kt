package com.guhungry.utilities.app

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.guhungry.utilities.R
import com.guhungry.utilities.app.base.BaseActivity
import com.guhungry.utilities.app.listexample.ExampleAdapter
import kotlinx.android.synthetic.main.activity_examples.*

typealias ExampleModel = Pair<String, Int>

class ExamplesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

        setupList()
    }

    private fun setupList() {
        list_example.layoutManager = LinearLayoutManager(this)

        list_example.adapter = ExampleAdapter(this, getExamplesList())
    }

    private fun getExamplesList(): List<ExampleModel> = listOf(
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel,
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel,
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel,
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel,
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel,
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel,
            "Image Utils" to R.drawable.icon_image,
            "XXX Utils" to android.R.drawable.ic_media_play,
            "YYY Utils" to android.R.drawable.ic_menu_close_clear_cancel
    )
}
