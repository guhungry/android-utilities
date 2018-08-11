package com.guhungry.utilities.app.rxjava

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guhungry.utilities.R
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.textChanges
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
    }

    private fun showBlankActivity() {
        startActivity(Intent(this, RxJavaBlankActivity::class.java))
    }

    override fun onResume() {
        super.onResume()

        setupExample1()
        setupExample2()
        setupExample3()
        setupExample4()
        active.set(true)
    }

    private val active = AtomicBoolean(false)
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

    private val observable2 = observable1.filter { it % 2 == 0 }
    private fun setupExample2() {
        disposables.add(
                observable2.subscribe { rxjava2.text = "%s %d".format(rxjava2.text, it) }
        )
    }

    private val observable3 by lazy { rxjava3_edit.textChanges()
            .skipInitialValue()
            .debounce (500, TimeUnit.MILLISECONDS)
            .filter { it.length > 3 } }
    private fun setupExample3() {
        disposables.add(
                observable3.subscribe { rxjava3.text = it }
        )
    }

    private val observable4 by lazy { blank_activity.clicks()
            .debounce(2, TimeUnit.SECONDS) }
    private fun setupExample4() {
        disposables.add(
                observable4.subscribe { showBlankActivity() }
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
