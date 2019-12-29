package br.com.mauriciobenigno.maxapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "codigo")
    val codigo: String,
    @ColumnInfo(name = "razao_social")
    val razao_social: String,
    @ColumnInfo(name = "nomeFantasia")
    val nomeFantasia: String,
    @ColumnInfo(name = "cnpj")
    val cnpj: String,
    @ColumnInfo(name = "ramo_atividade")
    val ramo_atividade: String,
    @ColumnInfo(name = "endereco")
    val endereco: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "contatos")
    val contatos: List<Contato>
)