package br.com.emersonfiwre.jetpacknavigation.ui.registration.profiledata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import br.com.emersonfiwre.jetpacknavigation.MainActivity
import br.com.emersonfiwre.jetpacknavigation.extensions.dismissError
import br.com.emersonfiwre.jetpacknavigation.ui.registration.RegistrationViewModel
import br.com.emersonfiwre.navigationdagger.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_profile_data.*
import javax.inject.Inject

class ProfileDataFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val registrationViewModel by viewModels<RegistrationViewModel> { viewModelFactory }

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        val validationFields = initValidateFields()
        listenToRegistrationStateEvent(validationFields)
        registerViewListeners()
        registerDeviceBackStackCallback()
    }

    private fun initValidateFields() = mapOf(
        RegistrationViewModel.INPUT_NAME.first to inputLayoutProfileDataName,
        RegistrationViewModel.INPUT_BIO.first to inputLayoutProfileDataBio
    )

    private fun listenToRegistrationStateEvent(validationFields: Map<String, TextInputLayout>) {
        registrationViewModel.registrationStateEvent.observe(viewLifecycleOwner,
            { registrationState ->
                when (registrationState) {
                    is RegistrationViewModel.RegistrationState.CollectCredentials -> {
                        val name = inputProfileDataName.text.toString()
                        val directions = ProfileDataFragmentDirections
                            .actionProfileDataFragmentToChooseCredentialsFragment(name)

                        navController.navigate(directions)
                    }
                    is RegistrationViewModel.RegistrationState.InvalidProfileData -> {
                        registrationState.fields.forEach { fieldError ->
                            validationFields[fieldError.first]?.error = getString(fieldError.second)
                        }
                    }
                }
            })
    }

    private fun registerViewListeners() {
        buttonProfileDataNext.setOnClickListener {
            val name = inputProfileDataName.text.toString()
            val bio = inputProfileDataBio.text.toString()

            registrationViewModel.collectProfileData(name, bio)
        }

        inputProfileDataName.addTextChangedListener {
            inputLayoutProfileDataName.dismissError()
        }

        inputProfileDataBio.addTextChangedListener {
            inputLayoutProfileDataBio.dismissError()
        }
    }

    private fun registerDeviceBackStackCallback() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            cancelRegistration()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        cancelRegistration()
        return true
    }

    private fun cancelRegistration() {
        registrationViewModel.userCancelledRegistration()
        navController.popBackStack(R.id.loginFragment, false)
    }


}