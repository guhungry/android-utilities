package com.guhungry.utilities.app.viewmodel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.guhungry.utilities.R
import com.guhungry.utilities.app.rxjava.RxJavaBlankActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {
    private val disposables = CompositeDisposable()
    private lateinit var viewModel: ViewModelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        viewModel = ViewModelProviders.of(this).get(ViewModelViewModel::class.java)
        viewModel.ints.observe(this, Observer<List<Int>> {
            text2.text = Gson().toJson(it)
        })

        blank_activity.setOnClickListener { showBlankActivity() }
    }

    private fun showBlankActivity() {
        startActivity(Intent(this, RxJavaBlankActivity::class.java))
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadData()
        disposables.add(
                viewModel.observable.subscribe { items, _ ->
                    text1.text = Gson().toJson(items)
                }
        )
    }

    override fun onPause() {
        super.onPause()

        disposables.clear()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (!disposables.isDisposed) disposables.dispose()
    }
}
