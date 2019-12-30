package br.com.mauriciobenigno.maxapp.ui.Activitys

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.mauriciobenigno.maxapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClientes.setOnClickListener {
            val intent = Intent(this, WorkActivity::class.java)
            this.startActivity(intent)
        }
        verificarInternet(this)
    }

    override fun onResume() {
        super.onResume()
        verificarInternet(this)

    }

    fun verificarInternet(context: Context){
        when(haveInternet(this)){
            true -> imgInternetConection.setImageResource(R.drawable.ic_maxima_nuvem_conectado)
            false -> imgInternetConection.setImageResource(R.drawable.ic_maxima_nuvem_desconectado)
        }
    }

    fun haveInternet(context: Context) : Boolean {
        /* solução baseada na indicação developers Android
        encontrada em https://developer.android.com/training/monitoring-device-state/connectivity-status-type*/
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return return isConnected
    }
}
