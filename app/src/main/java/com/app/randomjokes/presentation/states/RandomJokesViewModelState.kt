package com.app.randomjokes.presentation.states

import com.app.randomjokes.domain.Jokes

data class RandomJokesViewModelState(
	val isLoading: Boolean = false,
	val jokes: List<Jokes> = emptyList()
) {
	fun toUiState() = RandomJokesUiState(isLoading, jokes)
}
