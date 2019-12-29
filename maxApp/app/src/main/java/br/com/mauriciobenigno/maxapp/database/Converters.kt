package br.com.mauriciobenigno.maxapp.database

import androidx.room.TypeConverter
import br.com.mauriciobenigno.maxapp.models.Contato
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Converters {
    @TypeConverter
    fun listToJson(lista: List<String>?) : String {
        return Gson().toJson(lista)
    }

    @TypeConverter
    fun jsonToList(json: String): List<String>?{
        val lista = Gson().fromJson(json, Array<String>::class.java) as? Array<String>
        return lista?.toList()
    }

    @TypeConverter
    fun contatosToJson(lista: List<Contato>) : String {
        val builder = GsonBuilder()
        builder.serializeNulls() // Permite serializar valores nulos
        val gson = builder.setPrettyPrinting().create()
        return gson.toJson(lista)
    }


    @TypeConverter
    fun jsonToContatos(json: String): List<Contato>?{
        val gson = GsonBuilder().serializeNulls().create() // Permite deserializar valores nulos
        val lista = gson.fromJson(json, Array<Contato>::class.java) as? Array<Contato>
        return lista?.toList()
    }

}