package com.app.randomjokes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.randomjokes.domain.GetRandomJokesUseCase
import com.app.randomjokes.presentation.states.RandomJokesViewModelState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class RandomJokesViewModel(private val getRandomJokesUseCase: GetRandomJokesUseCase) : ViewModel() {

	private val viewModelState = MutableStateFlow(RandomJokesViewModelState())

	val uiState = viewModelState.map { it.toUiState() }
		.stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

	init {
		getRandomJokes()
	}

	private fun getRandomJokes() = viewModelScope.launch {
		viewModelState.update { it.copy(isLoading = true) }
		while (true) {
			val jokes = getRandomJokesUseCase()
			viewModelState.update { it.copy(jokes = jokes, isLoading = false) }
			delay(TimeUnit.MINUTES.toMillis(1))
		}
	}
}