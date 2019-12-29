package br.com.mauriciobenigno.maxapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.AdapterContatos
import br.com.mauriciobenigno.maxapp.models.Contato
import kotlinx.android.synthetic.main.fragment_dados_do_cliente.*

class DadosDoClienteFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //toolbar.setBackgroundColor(R.color.colorAccent)

        return inflater.inflate(R.layout.fragment_dados_do_cliente, container, false)
    }


    override fun onResume() {
        super.onResume()

        val listaMokada = listOf<Contato>(
            Contato("1","1","1","1","1","1","1","1",null),
            Contato("1","1","1","1","1","1","1","1",null)
    )
        recyclerViewContatos.adapter = AdapterContatos(listaMokada)
    }
}