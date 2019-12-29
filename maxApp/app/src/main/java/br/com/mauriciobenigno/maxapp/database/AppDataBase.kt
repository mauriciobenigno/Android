package br.com.mauriciobenigno.maxapp.database

import android.content.Context
import androidx.room.*
import br.com.mauriciobenigno.maxapp.models.Cliente
import br.com.mauriciobenigno.maxapp.models.Pedido

@Database(entities = [Pedido::class, Cliente::class], version = 13)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun maxAppDao() : maxAppDao

    companion object { // padrão singleton
        var INSTANCE : AppDataBase? = null

        fun getInstance(context : Context) : AppDataBase{
            return if (INSTANCE == null) // se instancia for nula
            {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "database.db"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE as AppDataBase // cria nova instancia e retorna
            }
            else{ // se instancia já existir
                INSTANCE as AppDataBase // retorna a instancia
            }

        }
    }

}