package br.com.mauriciobenigno.maxapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "pedidos")
data class pedido(
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
    val critica: String,
    @ColumnInfo(name = "legendas")
    val legendas: List<String>?
)