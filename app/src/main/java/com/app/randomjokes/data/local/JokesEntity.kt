package com.app.randomjokes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.randomjokes.domain.Jokes

@Entity("jokes_table")
data class JokesEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	val joke: String
) {
	fun toDomainJokes() = Jokes(joke)
}