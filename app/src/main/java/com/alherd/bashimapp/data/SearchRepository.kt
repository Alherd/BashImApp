package com.alherd.bashimapp.data

class SearchRepository(private val apiService: BashImApiService) {
    fun searchQuotes(site: String, name: String): io.reactivex.Observable<List<Quote>> {
        return apiService.searchQuotes(site, name, 50)
    }

    fun searchSources(): io.reactivex.Observable<List<Quote>> {
        return apiService.searchSources()
    }
}