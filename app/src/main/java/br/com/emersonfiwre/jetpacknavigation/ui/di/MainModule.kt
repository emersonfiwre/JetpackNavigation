package br.com.emersonfiwre.jetpacknavigation.ui.di

import androidx.lifecycle.ViewModel
import br.com.emersonfiwre.jetpacknavigation.di.ViewModelKey
import br.com.emersonfiwre.jetpacknavigation.ui.registration.RegistrationViewModel
import br.com.emersonfiwre.jetpacknavigation.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    fun bindRegistrationViewModel(viewModel: RegistrationViewModel): ViewModel
}