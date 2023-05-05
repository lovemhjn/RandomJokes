package com.app.randomjokes.di

import androidx.room.Room
import com.app.randomjokes.data.local.JokesDatabase
import com.app.randomjokes.data.remote.RandomJokesApiService
import com.app.randomjokes.data.remote.datasource.RandomJokesDataSource
import com.app.randomjokes.data.remote.datasource.RandomJokesDataSourceImpl
import com.app.randomjokes.data.remote.repository.RandomJokesRepositoryImpl
import com.app.randomjokes.domain.GetRandomJokesUseCase
import com.app.randomjokes.domain.RandomJokesRepository
import com.app.randomjokes.presentation.RandomJokesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
	single {
		Retrofit.Builder()
			.baseUrl("https://geek-jokes.sameerkumar.website")
			.addConverterFactory(MoshiConverterFactory.create())
			.build()
			.create(RandomJokesApiService::class.java)
	}
	factory<RandomJokesRepository> {
		RandomJokesRepositoryImpl(get())
	}

	factory<RandomJokesDataSource> {
		RandomJokesDataSourceImpl(get(), get())
	}

	factory {
		GetRandomJokesUseCase(get())
	}

	single {
		 Room.databaseBuilder(
			get(),
			JokesDatabase::class.java,
			"beers.db"
		).build()
	}

	viewModel {
		RandomJokesViewModel(get())
	}
}