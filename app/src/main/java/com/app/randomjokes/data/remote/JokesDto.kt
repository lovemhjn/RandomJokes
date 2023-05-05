package com.app.randomjokes.data.remote


import com.app.randomjokes.data.local.JokesEntity
import com.squareup.moshi.Json

data class JokesDto(
	@Json(name = "joke")
	val joke: String
) {
	fun toJokesEntity() = JokesEntity(joke = joke)
}