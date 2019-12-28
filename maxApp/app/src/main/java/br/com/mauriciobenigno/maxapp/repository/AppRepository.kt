package br.com.mauriciobenigno.maxapp.repository

import android.content.Context
import android.util.Log
import br.com.mauriciobenigno.maxapp.api.ApiService
import br.com.mauriciobenigno.maxapp.database.AppDataBase
import br.com.mauriciobenigno.maxapp.models.Pedidos
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository(val context: Context) {
    val database = AppDataBase.getInstance(context)

    fun getAllRequests() = database.maxAppDao().getAllLiveRequests()

    fun getRequestsFromServer(){
        val request = ApiService.getEndPoints()
        request.getAllRequests().enqueue(object : Callback<Pedidos>{
            override fun onFailure(call: Call<Pedidos>, t: Throwable) {
                Log.e("Falha", " Requisição de pedidos falhou. Cod: "+t.message)
            }

            override fun onResponse(call: Call<Pedidos>, response: Response<Pedidos>) {
                Log.d("Sucesso", " Requisição de Pedidos foi feita com sucesso!")
                if (response.code() == 200)
                {
                    val resultado = response.body()
                    resultado?.let { pedidos ->
                        val lista = pedidos.pedidos
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