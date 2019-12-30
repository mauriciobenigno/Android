package br.com.mauriciobenigno.maxapp.ui.Fragments.Dados

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.mauriciobenigno.maxapp.repository.AppRepository

class DadosDoClienteViewModel(application: Application): AndroidViewModel(application){

    private val appRepository = AppRepository(application)

    init {
        /* Sempre que o fragment de Dados do cliente for inicializado,
        * uma consulta será feita no servidor pegando os dados e adicionando
        * ao banco de dados local
        * */
        appRepository.getClientFromServer()
    }

    /* Busca a lista de pedidos armazenados no banco de dados local*/
    fun getClientInfo() = appRepository.getClientInfo()
}