package com.app.randomjokes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.randomjokes.databinding.ActivityMainBinding
import com.app.randomjokes.presentation.utils.makeVisible
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private val viewModel by viewModel<RandomJokesViewModel>()
	private lateinit var binding: ActivityMainBinding
	private val jokesAdapter by lazy { JokesAdapter() }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.rvJokes.adapter = jokesAdapter
		setObserver()
	}

	private fun setObserver() {
		lifecycleScope.launch {
			viewModel.uiState.collect {
				binding.progressBar.makeVisible(it.isLoading)
				jokesAdapter.submitList(it.jokes)
			}
		}
	}

}