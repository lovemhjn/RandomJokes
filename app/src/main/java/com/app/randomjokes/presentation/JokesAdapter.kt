package com.app.randomjokes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.randomjokes.databinding.ItemJokeBinding
import com.app.randomjokes.domain.Jokes

class JokesAdapter : ListAdapter<Jokes, JokesAdapter.JokesViewHolder>(JokesDiffCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
		val binding = ItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return JokesViewHolder(binding)
	}

	override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
		holder.bindData(getItem(position))
	}

	inner class JokesViewHolder(private val binding: ItemJokeBinding) : ViewHolder(binding.root) {
		fun bindData(joke: Jokes) {
			binding.tvJoke.text = joke.joke
		}
	}
}

class JokesDiffCallback : DiffUtil.ItemCallback<Jokes>() {
	override fun areItemsTheSame(oldItem: Jokes, newItem: Jokes): Boolean {
		// Compare the unique identifiers of the items (if they have any)
		return oldItem.hashCode() == newItem.hashCode()
	}

	override fun areContentsTheSame(oldItem: Jokes, newItem: Jokes): Boolean {
		// Compare all the fields of the items
		return oldItem == newItem
	}
}