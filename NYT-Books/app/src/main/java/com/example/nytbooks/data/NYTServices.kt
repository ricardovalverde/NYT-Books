package com.example.nytbooks.data

import com.example.nytbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "ZXC5g76EWGYAcj7dPXhbvZLgj1z77h8S",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}