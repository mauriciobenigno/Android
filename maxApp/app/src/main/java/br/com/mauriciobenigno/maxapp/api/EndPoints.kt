package br.com.mauriciobenigno.maxapp.api


import br.com.mauriciobenigno.maxapp.models.TempCliente
import br.com.mauriciobenigno.maxapp.models.TempPedidos
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("1bo7qj")
    fun getClientInfo() : Call<TempCliente>

    @GET("wjl97")
    fun getAllRequests() : Call<TempPedidos>


}