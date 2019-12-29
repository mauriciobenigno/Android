package br.com.mauriciobenigno.maxapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mauriciobenigno.maxapp.models.Cliente
import br.com.mauriciobenigno.maxapp.models.Pedido

@Dao
interface maxAppDao {
    @Query("SELECT * FROM pedidos")
    fun getAllRequests(): List<Pedido>

    @Query("SELECT * FROM pedidos")
    fun getAllLiveRequests(): LiveData<List<Pedido>>

    @Query("SELECT * FROM clientes LIMIT 1")
    fun getLiveClient(): LiveData<Cliente>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRequest(pedido: Pedido)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addClient(cliente: Cliente)
}