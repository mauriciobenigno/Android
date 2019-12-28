package br.com.mauriciobenigno.maxapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mauriciobenigno.maxapp.models.pedido

@Dao
interface maxAppDao {
    @Query("SELECT * FROM pedidos")
    fun getAllRequests(): List<pedido>

    @Query("SELECT * FROM pedidos")
    fun getAllLiveRequests(): LiveData<List<pedido>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRequest(pedido: pedido)
}