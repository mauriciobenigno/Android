package br.com.mauriciobenigno.maxapp.repository

import android.content.Context
import android.util.Log
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
                Log.e("Falha", " Requisição de cliente falhou. Cod: "+t.message)
            }

            override fun onResponse(call: Call<TempCliente>, response: Response<TempCliente>) {
                if (response.code() == 200)
                {
                    Log.d("Sucesso", " Requisição de cliente foi feita com sucesso!")
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
                //Log.e("Falha", " Requisição de pedidos falhou. Cod: "+t.message)
            }

            override fun onResponse(call: Call<TempPedidos>, response: Response<TempPedidos>) {
                //Log.d("Sucesso", " Requisição de Pedidos foi feita com sucesso!")
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