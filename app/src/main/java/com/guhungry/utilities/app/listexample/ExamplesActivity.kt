package com.guhungry.utilities.app.listexample

import android.content.Intent
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.guhungry.utilities.R
import com.guhungry.utilities.app.base.BaseActivity
import com.guhungry.utilities.app.imageutils.ImageUtilsActivity
import com.guhungry.utilities.app.retrofit.RetrofitActivity
import com.guhungry.utilities.app.rxjava.RxJavaActivity
import com.guhungry.utilities.app.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_examples.*

data class ExampleModel(val title: Int, @DrawableRes val icon: Int, val target: Class<*>)

class ExamplesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

        setupList()
    }

    private fun setupList() {
        list_example.layoutManager = LinearLayoutManager(this)

        list_example.adapter = ExampleAdapter(this, examples).apply {
            setOnItemClickListener { showExample(it) }
        }
    }

    private fun showExample(example: ExampleModel) {
        startActivity(Intent(this, example.target))
    }

    private val examples = listOf(
            ExampleModel(R.string.image_utils, R.drawable.icon_image, ImageUtilsActivity::class.java),
            ExampleModel(R.string.retrofit, R.drawable.icon_rxjava, RetrofitActivity::class.java),
            ExampleModel(R.string.rxjava, R.drawable.icon_rxjava, RxJavaActivity::class.java),
            ExampleModel(R.string.viewmodels, android.R.drawable.sym_def_app_icon, ViewModelActivity::class.java)
    )
}
