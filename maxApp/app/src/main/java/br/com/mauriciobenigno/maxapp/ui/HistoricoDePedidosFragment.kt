package br.com.mauriciobenigno.maxapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.AdapterPedidos
import kotlinx.android.synthetic.main.fragment_historico__de_pedidos.*

class HistoricoDePedidosFragment: Fragment(){

    lateinit var viewModel : HistoricoDePedidosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_historico__de_pedidos, container, false)
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.historico_pedidos_menu,menu)

        /* Para tornar o icone do menu visivel. Solução proposta por: Mena
        * em https://stackoverflow.com/questions/55826607/actionbar-menus-item-icons-not-shown-properly-upon-rtl */
        if (menu is MenuBuilder) { //To display icon on overflow menu
            menu.setOptionalIconsVisible(true)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.dialogLegendas -> {
                findNavController().navigate(R.id.action_historicoDePedidosFragment_to_dialogLegendas)
            }
        }
        return super.onOptionsItemSelected(item)
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
    }
}