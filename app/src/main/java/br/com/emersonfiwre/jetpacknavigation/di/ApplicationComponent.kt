package br.com.emersonfiwre.jetpacknavigation.di

import android.content.Context
import br.com.emersonfiwre.jetpacknavigation.ui.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, ViewModelBuilderModule::class, SubcomponentsModule::class, StringModule::class])
interface ApplicationComponent {//Pelo componente iniciar a injeção de dependencias feita pelo dagger

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory
}

@Module(subcomponents = [MainComponent::class])
object SubcomponentsModule