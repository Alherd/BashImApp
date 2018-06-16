package com.alherd.bashimapp

/**
 * Created by Olgerd on 16.06.2018.
 */
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import com.alherd.bashimapp.data.Quote
import com.alherd.bashimapp.data.SearchRepository
import com.alherd.bashimapp.data.SearchRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

const val INTENT_SITE_NAME = "site"
const val INTENT_NAME_NAME = "name"

class QuotesActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val repository: SearchRepository = SearchRepositoryProvider.provideSearchRepository()
    private val list: MutableList<Quote> = mutableListOf()

    @BindView(R.id.list)
    lateinit var listView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        listView.layoutManager = linearLayoutManager

        val site = intent.getStringExtra(INTENT_SITE_NAME)
        val name = intent.getStringExtra(INTENT_NAME_NAME)
        compositeDisposable.add(
                repository.searchQuotes(site, name)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            list.addAll(result)
                            listView.adapter = QuotesAdapter(list)
                            Log.d(TAG, list.toString())
                        })
        )
    }
}