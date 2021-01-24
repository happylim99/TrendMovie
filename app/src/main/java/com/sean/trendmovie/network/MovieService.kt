package com.sean.trendmovie.network

import com.sean.trendmovie.model.Movies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {

    @GET("trending/all/day?api_key=45718f0c6912aeb42897129e413d9b3b")
    fun getTrendingMovie() : Single<Movies>
}