package br.com.mauriciobenigno.maxapp.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(lista: List<String>?) : String {
        return Gson().toJson(lista)
    }

    @TypeConverter
    fun jsonToList(json: String): List<String>?{
        val lista = Gson().fromJson(json, Array<String>::class.java) as Array<String>
        return lista.toList()
    }
}