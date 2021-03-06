package br.com.mauriciobenigno.maxapp.ui.activitys

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.servicos.NotificationService
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
        stopService(Intent(this,NotificationService::class.java))
    }

    override fun onResume() {
        super.onResume()
        verificarInternet(this)
        stopService(Intent(this,NotificationService::class.java))
    }

    override fun onStop() {
        super.onStop()
        startService(Intent(this,NotificationService::class.java))
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
