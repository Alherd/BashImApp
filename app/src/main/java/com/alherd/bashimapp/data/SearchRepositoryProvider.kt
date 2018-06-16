package com.alherd.bashimapp.data

object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(BashImApiService.create())
    }
}