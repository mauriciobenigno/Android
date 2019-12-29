package br.com.mauriciobenigno.maxapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.AdapterContatos
import br.com.mauriciobenigno.maxapp.models.Contato
import kotlinx.android.synthetic.main.fragment_dados_do_cliente.*
import org.jetbrains.anko.doAsync

class DadosDoClienteFragment: Fragment(){

    lateinit var viewModel : DadosDoClienteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //toolbar.setBackgroundColor(R.color.colorAccent)
        return inflater.inflate(R.layout.fragment_dados_do_cliente, container, false)
    }


    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this).get(DadosDoClienteViewModel::class.java)

        viewModel.getClientInfo().observe(this, Observer {
            it?.let {
                txtCodigoRazaoSocial.text = "${it.id} - ${it.razao_social}"
                txtNomeFantasia.text = it.nomeFantasia
                it.cpf?.let {
                        cpf -> txtCPF.text=cpf
                    labelCPF.visibility = View.VISIBLE
                    txtCPF.visibility = View.VISIBLE
                }
                it.cnpj?.let {
                        cnpj -> txtCNPJ.text=cnpj
                    labelCNPJ.visibility = View.VISIBLE
                    txtCNPJ.visibility=View.VISIBLE
                }
                txtRamoAtividade.text = it.ramo_atividade
                txtEndereco.text = it.endereco

                it.contatos?.let { lista ->
                    recyclerViewContatos.adapter = AdapterContatos(lista)
                }
            }
        })
    }
}