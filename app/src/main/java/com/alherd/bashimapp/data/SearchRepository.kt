package com.alherd.bashimapp.data

class SearchRepository(private val apiService: BashImApiService) {
    fun searchQuotes(site: String, name: String, num: Int): io.reactivex.Observable<List<Quote>> {
        return apiService.searchQuotes(site, name, num)
    }

    fun searchSources(): io.reactivex.Observable<List<List<SourceOfQuotes>>> {
        return apiService.searchSources()
    }
}