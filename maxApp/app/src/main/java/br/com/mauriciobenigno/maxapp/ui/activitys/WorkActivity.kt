package br.com.mauriciobenigno.maxapp.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.mauriciobenigno.maxapp.R
import br.com.mauriciobenigno.maxapp.commons.servicos.NotificationService
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Menu de navegação em baixo
        val navigationHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment?
        NavigationUI.setupWithNavController(bottom_nav, navigationHostFragment!!.navController)

        stopService(Intent(this, NotificationService::class.java))
    }

    override fun onResume() {
        super.onResume()
        stopService(Intent(this,NotificationService::class.java))
    }
}
