package br.com.mauriciobenigno.maxapp.repository

import android.content.Context
import android.util.Log
import br.com.mauriciobenigno.maxapp.api.ApiService
import br.com.mauriciobenigno.maxapp.database.AppDataBase
import br.com.mauriciobenigno.maxapp.models.pedido
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository(val context: Context) {
    val database = AppDataBase.getInstance(context)

    fun getAllRequests() = database.maxAppDao().getAllLiveRequests()

    fun getRequestsFromServer(){
        val request = ApiService.getEndPoints()
        request.getAllRequests().enqueue(object : Callback<List<pedido>>{
            override fun onFailure(call: Call<List<pedido>>, t: Throwable) {
                Log.e("Falha", " Requisição de pedidos falhou")
            }

            override fun onResponse(call: Call<List<pedido>>, response: Response<List<pedido>>) {
                Log.d("Sucesso", " Requisição de pedidos foi feita com sucesso!")
            }
        })

    }

}