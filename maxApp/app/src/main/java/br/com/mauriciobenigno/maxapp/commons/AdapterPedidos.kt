package br.com.mauriciobenigno.maxapp.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.models.pedido

class AdapterPedidos(val dataSet: List<pedido>) : RecyclerView.Adapter<AdapterPedidos.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        /* Campo onde são mostrados os numeros RCA e ERP*/
        val numeroPedido= itemView.findViewById<TextView>(R.id.txtNumeroPedido)

        /* Campo onde são mostrados numero e o nome do cliente*/
        val infoCliente = itemView.findViewById<TextView>(R.id.txtNumeroCliente)

        /* Onde é apresentado a data caso o dia seja diferente ou  o horario caso seja no mesmo dia*/
        val data = itemView.findViewById<TextView>(R.id.txtDataHora)

        /* Campo onde informa o status do processamento */
        val status = itemView.findViewById<TextView>(R.id.txtStatusPedido)

        /* Imagem que indica o tipo de critica do produto */
        val critica = itemView.findViewById<ImageView>(R.id.imgTipoCritica)

        /* Imagem e fundo, que indicam o tipo de pedido*/
        val imagemTipoPedido = itemView.findViewById<ImageView>(R.id.imgTipoCritica)
        val fundoTipoPedido = itemView.findViewById<CardView>(R.id.cardImgPedido)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_pedido_item, parent, false)
        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedidoAtual = dataSet[position]

        /* Numeros RCA e ERP dos pedidos*/
        holder.numeroPedido.text = "${pedidoAtual.numero_ped_Rca}/${pedidoAtual.numero_ped_Rca}"

        /* Codigo e nome do Cliente*/
        holder.infoCliente.text = "${pedidoAtual.codigoCliente} - ${pedidoAtual.NOMECLIENTE}"

        /* Status*/
        holder.status.text = pedidoAtual.status
    }

}