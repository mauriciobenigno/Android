package br.com.mauriciobenigno.maxapp.models

data class pedido(
    val numero_ped_Rca: Int,
    val numero_ped_erp: String,
    val codigoCliente: String,
    val NOMECLIENTE: String,
    val data: String,
    val status: String,
    val critica: String,
    val legendas: List<String>?
)