package br.com.mauriciobenigno.maxapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mauriciobenigno.maxapp.R
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
}