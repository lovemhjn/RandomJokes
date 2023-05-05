package com.app.randomjokes.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RandomJokesApiService {

	@GET("/api?format=json")
	suspend fun getRandomJokes(): Response<JokesDto>
}