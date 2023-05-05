package com.app.randomjokes.data.remote.datasource

import com.app.randomjokes.data.local.JokesDatabase
import com.app.randomjokes.data.local.JokesEntity
import com.app.randomjokes.data.remote.RandomJokesApiService

class RandomJokesDataSourceImpl(
	private val apiService: RandomJokesApiService,
	private val jokesDatabase: JokesDatabase
) : RandomJokesDataSource {

	override suspend fun getRandomJokes(): List<JokesEntity> {
		val dao = jokesDatabase.dao
		try {
			val remoteJoke = apiService.getRandomJokes()

			if (remoteJoke.isSuccessful && remoteJoke.body() != null) {
				if (dao.getJokesCount() >= 10) {
					dao.deleteFirstJoke()
				}
				dao.saveJoke(remoteJoke.body()!!.toJokesEntity())

			}
		} catch (ex: Exception) {
			ex.printStackTrace()
		}
		return dao.getAllJokes()
	}
}