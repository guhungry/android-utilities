package com.guhungry.utilities.app.listexample

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.guhungry.utilities.R
import com.guhungry.utilities.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_examples.*

data class ExampleModel(val title: String, val icon: Int)

class ExamplesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

        setupList()
    }

    private fun setupList() {
        list_example.layoutManager = LinearLayoutManager(this)

        list_example.adapter = ExampleAdapter(this, examples)
    }

    private val examples: List<ExampleModel> = listOf(
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel),
            ExampleModel("Image Utils", R.drawable.icon_image),
            ExampleModel("XXX Utils", android.R.drawable.ic_media_play),
            ExampleModel("YYY Utils", android.R.drawable.ic_menu_close_clear_cancel)
    )
}
