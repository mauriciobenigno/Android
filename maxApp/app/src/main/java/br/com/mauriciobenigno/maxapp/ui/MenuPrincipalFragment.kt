package br.com.mauriciobenigno.maxapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.mauriciobenigno.maxapp.R
import kotlinx.android.synthetic.main.fragment_menu_principal.*

class MenuPrincipalFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_principal, container, false)
    }

    override fun onResume() {
        super.onResume()

        btnClientes.setOnClickListener {
            Toast.makeText(it.context,"TESTE", Toast.LENGTH_SHORT).show()
        }
    }
}