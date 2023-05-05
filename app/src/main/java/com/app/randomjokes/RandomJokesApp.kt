package com.app.randomjokes

import android.app.Application
import com.app.randomjokes.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class RandomJokesApp : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@RandomJokesApp)
			modules(appModule)
		}
	}
}