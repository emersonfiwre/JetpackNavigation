package br.com.emersonfiwre.jetpacknavigation

import android.app.Application
import br.com.emersonfiwre.jetpacknavigation.di.ApplicationComponent
import br.com.emersonfiwre.jetpacknavigation.di.DaggerApplicationComponent

class NavigationApp : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}