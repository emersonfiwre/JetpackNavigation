package br.com.emersonfiwre.jetpacknavigation.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.emersonfiwre.navigationdagger.R
import br.com.emersonfiwre.jetpacknavigation.extensions.navigateWithAnimations
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id_btn_next.setOnClickListener {
            //sempre usar o id da ação, só usar id da tela quando for uma tela fora do fluxo apresentada so na primeira entrada
            findNavController().navigateWithAnimations(R.id.action_startFragment_to_profileFragment)

        }
    }
}