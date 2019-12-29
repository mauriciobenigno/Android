package br.com.mauriciobenigno.maxapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.AdapterPedidos
import kotlinx.android.synthetic.main.fragment_historico__de_pedidos.*

class HistoricoDePedidosFragment: Fragment(){

    lateinit var viewModel : HistoricoDePedidosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_historico__de_pedidos, container, false)
    }

    override fun onResume() {
        super.onResume()

        // Recupera a viewmodel da classe Viewmodel deste fragmento
        viewModel = ViewModelProviders.of(this).get(HistoricoDePedidosViewModel::class.java)
        /* Usa o padrão observer para realizar a adição de novos pedidos a medida em que novos
        * pedidos são adicionados ao banco de dados*/
        viewModel.getAllResquests().observe(this, Observer { pedidos ->
            pedidos?.let {
                recyclerViewPedidos.adapter = AdapterPedidos(pedidos)
            }
        })


        /*val listaMokada = listOf<pedido>(
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null),
            pedido(1,"2","3","mau","4","5","6",null)
        )
        recyclerViewPedidos.adapter = AdapterPedidos(listaMokada)*/
    }
}