package com.alherd.bashimapp.data

import com.google.gson.annotations.SerializedName

data class Quote(
        @SerializedName("site")
        val site: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("desc")
        val desc: String,
        @SerializedName("elementPureHtml")
        val htmlText: String,
        @SerializedName("link")
        val link: String = ""
)

data class SourceOfQuotes(
        @SerializedName("site")
        val site: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("desc")
        val desc: String,
        @SerializedName("elementPureHtml")
        val htmlText: String,
        @SerializedName("link")
        val link: String = ""
)