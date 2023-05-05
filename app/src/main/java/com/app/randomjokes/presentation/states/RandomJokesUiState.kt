package com.app.randomjokes.presentation.states

import com.app.randomjokes.domain.Jokes

data class RandomJokesUiState(
	val isLoading: Boolean,
	val jokes: List<Jokes>
)
