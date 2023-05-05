package com.app.randomjokes.domain

interface RandomJokesRepository {

	suspend fun getRandomJokes(): List<Jokes>
}