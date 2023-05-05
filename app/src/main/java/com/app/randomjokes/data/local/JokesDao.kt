package com.app.randomjokes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JokesDao {

	@Query("SELECT * FROM jokes_table")
	suspend fun getAllJokes(): List<JokesEntity>

	@Query("SELECT COUNT(*) FROM jokes_table")
	suspend fun getJokesCount(): Int

	@Query("DELETE FROM jokes_table WHERE id = (SELECT id FROM jokes_table ORDER BY id ASC LIMIT 1)")
	suspend fun deleteFirstJoke()

	@Insert
	suspend fun saveJoke(joke: JokesEntity)
}