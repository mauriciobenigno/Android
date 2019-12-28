package br.com.mauriciobenigno.maxapp.api

import br.com.mauriciobenigno.maxapp.models.Pedidos
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {
    //@GET("1bo7qj")
    //fun getClient() : Call<cliente>

    @GET("wjl97")
    fun getAllRequests() : Call<Pedidos>

    /*@GET("wjl97")
    fun getAllRequests() : Call<List<pedido>>*/
}