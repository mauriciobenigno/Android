package br.com.mauriciobenigno.maxapp.commons.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.models.Contato
import java.text.SimpleDateFormat


class AdapterContatos(val dataSet: List<Contato>) : RecyclerView.Adapter<AdapterContatos.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textoNome = itemView.findViewById<TextView>(R.id.txtNomeContato)
        val textoTelefone = itemView.findViewById<TextView>(R.id.txtTelefone)
        val textoCelular = itemView.findViewById<TextView>(R.id.txtCelular)
        val textoConjugue = itemView.findViewById<TextView>(R.id.txtNomeConjugue)
        val textoTipo = itemView.findViewById<TextView>(R.id.txtTipo)
        val textoHobbie = itemView.findViewById<TextView>(R.id.txtHobbie)
        val textoEmail = itemView.findViewById<TextView>(R.id.txtEmail)
        val textoNascimento = itemView.findViewById<TextView>(R.id.txtDataNascimento)
        val textoNascConjugue = itemView.findViewById<TextView>(R.id.txtDataNascConjugue)
        val textoTime = itemView.findViewById<TextView>(R.id.txtTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_contatos_item, parent, false)
        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contatoAtual = dataSet[position]

        holder.textoNome.text = contatoAtual.nome
        holder.textoTelefone.text = contatoAtual?.telefone
        holder.textoCelular.text = contatoAtual?.celular
        holder.textoConjugue.text = contatoAtual?.conjuge
        holder.textoTipo.text = contatoAtual?.tipo
        //holder.textoHobbie.text = contatoAtual?.
        holder.textoEmail.text = contatoAtual?.e_mail
        /* Formatando data de nascimento*/
        contatoAtual.data_nascimento?.let {
            var date = SimpleDateFormat("yyyy-MM-dd").parse(contatoAtual.data_nascimento)
            holder.textoNascimento.text = SimpleDateFormat("dd/MM/YYYY").format(date)
        }
        contatoAtual.dataNascimentoConjuge?.let {
            var date = SimpleDateFormat("yyyy-MM-dd").parse(contatoAtual.dataNascimentoConjuge)
            holder.textoNascConjugue.text = SimpleDateFormat("dd/MM/YYYY").format(date)
        }
        holder.textoTime.text = contatoAtual.time
    }

}