package br.com.mauriciobenigno.maxapp.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import br.com.mauriciobenigno.maxapp.api.ApiService
import br.com.mauriciobenigno.maxapp.database.AppDataBase
import br.com.mauriciobenigno.maxapp.models.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppRepository(val context: Context) {
    val database = AppDataBase.getInstance(context)

    fun getAllRequests() = database.maxAppDao().getAllLiveRequests()

    fun getClientInfo() = database.maxAppDao().getLiveClient()

    fun getClientFromServer(){
        val request = ApiService.getEndPoints()
        request.getClientInfo().enqueue(object : Callback<TempCliente>{
            override fun onFailure(call: Call<TempCliente>, t: Throwable) {
                /*Toast.makeText(context,"Não foi possível verificar as atualizações do cliente!",
                    Toast.LENGTH_SHORT).show()*/
            }

            override fun onResponse(call: Call<TempCliente>, response: Response<TempCliente>) {
                if (response.code() == 200)
                {
                    //Toast.makeText(context,"Dados cliente atualizados!", Toast.LENGTH_SHORT).show()
                    val resultado = response.body()
                    resultado?.let { temp ->
                        doAsync {
                            database.maxAppDao().addClient(temp.cliente)
                        }
                    }

                }
            }
        })
    }

    fun getRequestsFromServer(){
        val request = ApiService.getEndPoints()
        request.getAllRequests().enqueue(object : Callback<TempPedidos>{
            override fun onFailure(call: Call<TempPedidos>, t: Throwable) {
                /*Toast.makeText(context,"Não foi possível verificar se a novos pedidos, tente novamente!",
                    Toast.LENGTH_SHORT).show()*/
            }

            override fun onResponse(call: Call<TempPedidos>, response: Response<TempPedidos>) {
                //Toast.makeText(context,"Histórico de pedidos atualizado!", Toast.LENGTH_SHORT).show()
                if (response.code() == 200)
                {
                    val resultado = response.body()
                    resultado?.let { temp ->
                        val lista = temp.pedidos
                        lista?.forEach{
                            doAsync {
                                database.maxAppDao().addRequest(it)
                            }
                        }
                    }
                }
            }
        })
    }
}