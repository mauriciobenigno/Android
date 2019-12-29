package br.com.mauriciobenigno.maxapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.AdapterContatos
import br.com.mauriciobenigno.maxapp.models.Contato
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
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

        btnVerificarStatus.setOnClickListener{

            val snack = Snackbar.make(it,"TESTE", Snackbar.LENGTH_SHORT).setAction("FECHAR"){}
            /* Solução proposta por Morozov em 'https://stackoverflow.com/questions/58749519/move-snackbar-above-the-bottomnavigationview'
            * Essa solução faz com que a snackbar não sobreponha o bottom navigation
            * Tal solução consiste em pegar a snack criada, e posicionar ela em uma posição que não
            * sobrepõe a nav, com base no valor de dimen setado para ela*/
            val params = snack.view.layoutParams as FrameLayout.LayoutParams
            params.setMargins(0, 0, 0, this.resources.getDimension(R.dimen.bottom_bar_size).toInt())
            snack.view.layoutParams = params
            // alterando a cor do "Fechar'
            snack.setActionTextColor(Color.parseColor("#638735"))
            snack.show()
        }


    }
}