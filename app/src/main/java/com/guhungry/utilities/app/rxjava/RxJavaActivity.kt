package com.guhungry.utilities.app.rxjava

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guhungry.utilities.R
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rx_java.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

class RxJavaActivity : AppCompatActivity() {
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)

        blank_activity.setOnClickListener { showBlankActivity() }
    }

    private fun showBlankActivity() {
        startActivity(Intent(this, RxJavaBlankActivity::class.java))
    }

    override fun onResume() {
        super.onResume()

        active.set(true)
        setupExample1()
    }

    private val active = AtomicBoolean(true)
    private val ticker = Flowable.interval(1, TimeUnit.SECONDS)
            .takeWhile { active.get() }
            .repeat()
    private val observable1 = Flowable.zip(
            Flowable.range(1, 100),
            ticker,
            BiFunction<Int, Long, Int> { int, _ -> int }
    )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .publish()
            .autoConnect()

    private fun setupExample1() {
        disposables.add(
                observable1.subscribe { rxjava1.text = "%s %d".format(rxjava1.text, it) }
        )
    }

    override fun onPause() {
        super.onPause()

        active.set(false)
        disposables.clear()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (!disposables.isDisposed) disposables.dispose()
    }
}
