package br.com.mauriciobenigno.maxapp.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.models.pedido

class AdapterPedidos(val dataSet: List<pedido>) : RecyclerView.Adapter<AdapterPedidos.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_pedido_item, parent, false)
        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedidoAtual = dataSet[position]
    }

}