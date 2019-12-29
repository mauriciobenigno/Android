package br.com.mauriciobenigno.maxapp.commons

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.models.Contato
import br.com.mauriciobenigno.maxapp.models.pedido
import org.jetbrains.anko.backgroundColor
import java.text.SimpleDateFormat
import java.util.*

class AdapterContatos(val dataSet: List<Contato>) : RecyclerView.Adapter<AdapterContatos.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_contatos_item, parent, false)
        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedidoAtual = dataSet[position]
    }

}