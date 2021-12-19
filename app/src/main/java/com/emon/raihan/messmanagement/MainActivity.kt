package com.emon.raihan.messmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.emon.raihan.messmanagement.util.DialogCustom
import com.emon.raihan.messmanagement.util.DialogCustom.logout
import com.emon.raihan.messmanagement.util.GlobalVariable
import com.emon.raihan.messmanagement.util.TextContants
import com.emon.raihan.messmanagement.view.welcome.Welcome
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var globalVariable: GlobalVariable

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var imageViewHeaderMenuClose: ImageView
    var doubleBackToExitPressedOnce: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        globalVariable = this.applicationContext as GlobalVariable

        var navigationView = findViewById<View>(R.id.navigation_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navigationView.itemIconTintList = null;
        val hView = navigationView.getHeaderView(0)
        imageViewHeaderMenuClose = hView.findViewById(R.id.closeHeader)

        imageViewHeaderMenuClose.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
        }




        tv_register.setOnClickListener {
            // val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }



        btnLogin.setOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (TextContants.banglaLanguageCode == globalVariable.languageCode) {

            when (item.itemId) {
                R.id.atm_id -> {
                    // val intent = Intent(this, ATMLocationActivity::class.java)
                    startActivity(intent)
                    //CustomActivityClear.doClearActivity(intent, this)
                    drawerLayout.closeDrawers()


                }
                R.id.branch_location_id -> {
                    // val intent = Intent(this, BranchLocationActivity::class.java)
                    startActivity(intent)
                    // CustomActivityClear.doClearActivity(intent, this)
                    drawerLayout.closeDrawers()
                }
                R.id.home_id -> {
                    // val intent = Intent(this, RegistrationActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.notification_id -> {
                    // val intent = Intent(this, NotificationActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.aboutus_id -> {
                    //val intent = Intent(this, AboutusActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.service_id -> {
                    // val intent = Intent(this, ServiceActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.terms_and_condition_id -> {
                    //  val intent = Intent(this, TermsAndConditionsActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.contact_us_id -> {
                    //val intent = Intent(this, ContactActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.language_settings_id -> {
                    //showCustomDialog()
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.safetytips_id -> {
                    // val intent = Intent(this, SafetyActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                }
                R.id.tranlimit_id -> {
                    // val intent = Intent(this, TransactionalLimitActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                }
                R.id.exit_id -> {
                    //Custom_alert.appClose(this, globalVariable.languageCode)
                }
            }

        } else {
            when (item.itemId) {
                R.id.atm_id -> {
                    // val intent = Intent(this, ATMLocationActivity::class.java)
                    startActivity(intent)
                    //CustomActivityClear.doClearActivity(intent, this)
                    drawerLayout.closeDrawers()
                }
                R.id.branch_location_id -> {
                    // val intent = Intent(this, BranchLocationActivity::class.java)
                    startActivity(intent)
                    // CustomActivityClear.doClearActivity(intent, this)
                    drawerLayout.closeDrawers()
                }
                R.id.home_id -> {
                    //val intent = Intent(this, RegistrationActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.notification_id -> {
                    //val intent = Intent(this, NotificationActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.aboutus_id -> {
                    // val intent = Intent(this, AboutusActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.service_id -> {
                    // val intent = Intent(this, ServiceActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.terms_and_condition_id -> {
                    //val intent = Intent(this, TermsAndConditionsActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.contact_us_id -> {
                    // val intent = Intent(this, ContactActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.language_settings_id -> {
                   // showCustomDialog()
                    drawerLayout.closeDrawers()
                    //CustomActivityClear.doClearActivity(intent, this)
                }
                R.id.safetytips_id -> {
                    //val intent = Intent(this, SafetyActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                }
                R.id.tranlimit_id -> {
                   // val intent = Intent(this, TransactionalLimitActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                }
                R.id.exit_id -> {
                   // Custom_alert.appClose(this, globalVariable.languageCode)
                }
            }
        }
        //close navigation drawer
        //mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_right_side_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
//            R.id.logout -> {
//                DialogCustom.englishcustomLogout(this)
//            }

        }

        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)

    }
}