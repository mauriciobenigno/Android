package br.com.mauriciobenigno.maxapp.ui.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.mauriciobenigno.maxapp.R
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        val navigationHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment?
        NavigationUI.setupWithNavController(bottom_nav, navigationHostFragment!!.navController)
    }
}
