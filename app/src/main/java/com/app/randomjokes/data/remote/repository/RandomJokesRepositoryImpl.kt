package com.app.randomjokes.data.remote.repository

import com.app.randomjokes.data.remote.datasource.RandomJokesDataSource
import com.app.randomjokes.domain.RandomJokesRepository

class RandomJokesRepositoryImpl(private val dataSource: RandomJokesDataSource) :
	RandomJokesRepository {

	override suspend fun getRandomJokes() = dataSource.getRandomJokes().map { jokesEntity ->
		jokesEntity.toDomainJokes()
	}
}