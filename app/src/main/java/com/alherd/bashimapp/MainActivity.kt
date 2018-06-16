package com.alherd.bashimapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import com.alherd.bashimapp.data.SearchRepository
import com.alherd.bashimapp.data.SearchRepositoryProvider
import com.alherd.bashimapp.data.SourceOfQuotes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

const val TAG: String = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val repository: SearchRepository = SearchRepositoryProvider.provideSearchRepository()
    private val list: MutableList<SourceOfQuotes> = mutableListOf()

    @BindView(R.id.list)
    private lateinit var listView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        listView.layoutManager = linearLayoutManager
        compositeDisposable.add(
                repository.searchSources()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            result.forEach { list.addAll(it) }
                            listView.adapter = SourceOfQuotesAdapter(list)
                            Log.d(TAG, list.toString())
                        })
        )
    }
}
