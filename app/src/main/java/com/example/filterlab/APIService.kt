package com.example.filterlab

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"

        @Volatile
        private var INSTANCE: APIServiceInterface? = null

        fun getService(): APIServiceInterface {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildService()
                }
            }
            return INSTANCE!!
        }

        private fun buildService(): APIServiceInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(APIServiceInterface::class.java)
        }
    }
}