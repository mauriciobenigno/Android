package br.com.mauriciobenigno.maxapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/* Classe Pedidos foi feita somente para receber os dados da API, por conta da forma em que o Json é recebido */
data class Pedidos (val pedidos: List<pedido>? = null)

@Entity(tableName = "pedidos")
data class pedido(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "numero_ped_rca")
    val numero_ped_Rca: Int,
    @ColumnInfo(name = "numero_ped_erp")
    val numero_ped_erp: String,
    @ColumnInfo(name = "codigocliente")
    val codigoCliente: String,
    @ColumnInfo(name = "nomecliente")
    val NOMECLIENTE: String,
    @ColumnInfo(name = "data")
    val data: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "critica")
    val critica: String? = null,
    @ColumnInfo(name = "tipo")
    val tipo: String,
    @ColumnInfo(name = "legendas")
    val legendas: List<String>? = null
)