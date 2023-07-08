package com.example.myeleven.network


import com.example.myeleven.models.MatchInfo
import com.example.myeleven.models.PlayerOldObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("nzin01312019187360.json")
    suspend fun getTeamPlayersForMatch(): Response<MatchInfo>  // Modify the response type as per your API response
}


object NetworkClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://demo.sportz.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService: ApiService = retrofit.create(ApiService::class.java)

}