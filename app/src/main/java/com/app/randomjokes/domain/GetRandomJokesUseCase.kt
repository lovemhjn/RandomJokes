package com.app.randomjokes.domain

class GetRandomJokesUseCase(private val repository: RandomJokesRepository) {

	suspend operator fun invoke() = repository.getRandomJokes()
}