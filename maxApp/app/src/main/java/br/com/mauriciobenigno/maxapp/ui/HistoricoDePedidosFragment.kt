package br.com.mauriciobenigno.maxapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.AdapterPedidos
import br.com.mauriciobenigno.maxapp.models.pedido
import kotlinx.android.synthetic.main.fragment_historico__de_pedidos.*

class HistoricoDePedidosFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_historico__de_pedidos, container, false)
    }

    override fun onResume() {
        super.onResume()



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