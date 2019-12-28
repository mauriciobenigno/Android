package br.com.mauriciobenigno.maxapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.mauriciobenigno.maxapp.repository.AppRepository

class HistoricoDePedidosViewModel(application: Application): AndroidViewModel(application){

    private val appRepository = AppRepository(application)

    init {
        /* Sempre que o fragment de Historico de pedidos for inicializado,
        * uma consulta será feita no servidor pegando os novos pedidos e alimentando
        * o banco de dados local
        * */
        appRepository.getRequestsFromServer()
    }

    /* Busca a lista de pedidos armazenados no banco de dados local*/
    fun getAllResquests() = appRepository.getAllRequests()
}