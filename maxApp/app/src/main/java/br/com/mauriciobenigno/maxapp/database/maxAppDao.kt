package br.com.mauriciobenigno.maxapp.database

import androidx.lifecycle.LiveData
import androidx.room.Query
import br.com.mauriciobenigno.maxapp.models.pedido

interface maxAppDao {
    @Query("SELECT * FROM pedidos")
    fun getAllRequests(): List<pedido>

    @Query("SELECT * FROM pedidos")
    fun getAllLiveRequests(): LiveData<List<pedido>>
}