package com.app.randomjokes.data.remote.datasource

import com.app.randomjokes.data.local.JokesEntity

interface RandomJokesDataSource {

	suspend fun getRandomJokes(): List<JokesEntity>
}