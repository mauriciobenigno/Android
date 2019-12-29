package br.com.mauriciobenigno.maxapp.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.models.Pedido
import org.jetbrains.anko.backgroundColor
import java.text.SimpleDateFormat
import java.util.*

class AdapterPedidos(val dataSet: List<Pedido>) : RecyclerView.Adapter<AdapterPedidos.ViewHolder>() {

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
        val imagemCritica = itemView.findViewById<ImageView>(R.id.imgTipoCritica)
        val labelCritica = itemView.findViewById<TextView>(R.id.labelCritica)

        /* Imagem da legenda */
        val imagemLegenda = itemView.findViewById<ImageView>(R.id.imgLegenda)

        /* Imagem e fundo, que indicam o tipo de pedido*/
        val imagemTipoPedido = itemView.findViewById<ImageView>(R.id.imgTipoPedido)
        val textoTipoPedido = itemView.findViewById<TextView>(R.id.txtTipoPedido)
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

        /* Dia ou Horario
        * Compara se o dia atual é o mesmo do pedido, caso seja, será exibido o
        * horario, caso contrario, será exibido a data*/
        var date = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssz").parse(pedidoAtual.data)
        if(SimpleDateFormat("dd MMM").format(date)==SimpleDateFormat("dd MMM").format(Date())){
            holder.data.text = SimpleDateFormat("HH:mm").format(date)
        }
        else{
            holder.data.text = SimpleDateFormat("dd MMM").format(date)
        }

        /* Critica*/
        pedidoAtual.critica?.let {

            holder.imagemCritica.setImageResource(
                when(pedidoAtual.critica){
                   "SUCESSO" -> R.drawable.ic_maxima_critica_sucesso
                   "FALHA_PARCIAL" -> R.drawable.ic_maxima_critica_alerta
                   "AGUARDANDO" -> R.drawable.ic_maxima_aguardando_critica
                   /* "FALHA_TOTAL"  Falha total não possui icone */
                    else -> R.drawable.ic_maxima_critica_sucesso
                }
            )
            // Como não é nulo, a critica é tornada visivel
            holder.labelCritica.visibility=View.VISIBLE
            holder.imagemCritica.visibility=View.VISIBLE
        }

        /* Legendas */
        pedidoAtual.legendas?.let {
            it.forEach { legenda ->
                holder.imagemLegenda.setImageResource(when(legenda){
                    "PEDIDO_SOFREU_CORTE" -> R.drawable.ic_maxima_legenda_corte
                    "PEDIDO_FEITO_TELEMARKETING" -> R.drawable.ic_maxima_legenda_telemarketing
                    "PEDIDO_CANCELADO_ERP" -> R.drawable.ic_maxima_legenda_cancelamento
                    "PEDIDO_DEVOLVIDO" -> R.drawable.ic_maxima_legenda_devolucao
                    "PEDIDO_EM_FALTA" -> R.drawable.ic_maxima_legenda_falta
                    else -> R.drawable.ic_maxima_legenda_corte
                })
            }
            holder.imagemLegenda.visibility = View.VISIBLE
        }
        /* Background da imagem baseado no status*/
        /*holder.imagemTipoPedido.background = when(pedidoAtual.status){
            "Pendente" -> R.color.cor_status_pendente
            "Em processamento" -> R.color.cor_status_em_processamento
            "Recusado" -> R.color.cor_status_recusado
            "Bloqueado" -> R.color.cor_status_bloqueado
            "Liberado" -> R.color.cor_status_liberado
            "Montado" -> R.color.cor_status_montado
            "Faturado" -> R.color.cor_status_faturado
            "Cancelado" -> R.color.cor_status_cancelado
            "Em orçamento" -> R.color.cor_status_em_orcamento
            else -> R.color.cor_status_liberado
        })*/

        when(pedidoAtual.status){
            "Pendente" ->{
                holder.textoTipoPedido.text = pedidoAtual.tipo[0].toString()
                holder.textoTipoPedido.backgroundColor = R.color.cor_status_pendente
                holder.textoTipoPedido.visibility = View.VISIBLE
            }
            /*"Em processamento" ->{
                holder.imagemTipoPedido.setImageResource(R.drawable.ic_maxima_em_processamento)
                holder.imagemTipoPedido.backgroundColor = R.color.cor_status_cancelado
                holder.imagemTipoPedido.visibility = View.VISIBLE
            }*/
            "Recusado" -> R.color.cor_status_recusado
            "Bloqueado" -> R.color.cor_status_bloqueado
            "Liberado" -> R.color.cor_status_liberado
            "Montado" -> R.color.cor_status_montado
            "Faturado" -> R.color.cor_status_faturado
            "Cancelado" -> R.color.cor_status_cancelado
            "Em orçamento" -> R.color.cor_status_em_orcamento
            else -> {
                holder.textoTipoPedido.text = pedidoAtual.tipo[0].toString()
                //holder.textoTipoPedido.backgroundColor = R.color.cor_status_pendente
                holder.textoTipoPedido.backgroundColor = R.color.cor_status_liberado
                holder.textoTipoPedido.visibility = View.VISIBLE
                /*AjustaImagemPedido(true,R.color.cor_status_pendente)*/
            }
        }

    }

    fun AjustaImagemPedido(tipo: Boolean ,cor: Int){
        /* Tipo 0 - Texto, Tipo 1 - Imagem */
        if(tipo){

        }
        else
        {

        }

    }

}