package br.com.emersonfiwre.jetpacknavigation.ui.di

import br.com.emersonfiwre.jetpacknavigation.MainActivity
import br.com.emersonfiwre.jetpacknavigation.ui.login.LoginFragment
import br.com.emersonfiwre.jetpacknavigation.ui.profile.ProfileFragment
import br.com.emersonfiwre.jetpacknavigation.ui.registration.choosecredentials.ChooseCredentialsFragment
import br.com.emersonfiwre.jetpacknavigation.ui.registration.profiledata.ProfileDataFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: LoginFragment)
    fun inject(activity: ProfileFragment)
    fun inject(activity: ProfileDataFragment)
    fun inject(activity: ChooseCredentialsFragment)
}