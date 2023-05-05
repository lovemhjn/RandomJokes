package com.app.randomjokes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
	entities = [JokesEntity::class],
	version = 1
)
abstract class JokesDatabase : RoomDatabase() {

	abstract val dao: JokesDao
}