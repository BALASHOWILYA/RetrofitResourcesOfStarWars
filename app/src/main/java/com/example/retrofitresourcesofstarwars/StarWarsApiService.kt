package com.example.retrofitresourcesofstarwars

import com.example.retrofitresourcesofstarwars.retrofit.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApiService {

    @GET("people/{id}")
    suspend fun searchCharacters(@Path("id") id: Int): Character

}