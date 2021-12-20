package com.emon.raihan.messmanagement.view.welcome

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import androidx.navigation.ui.setupWithNavController
import com.emon.raihan.messmanagement.R
import com.emon.raihan.messmanagement.util.GlobalVariable
import com.emon.raihan.messmanagement.util.TextContants

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Welcome : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var toolbarinside: Toolbar
    private lateinit var globalVariable: GlobalVariable
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var imageViewHeaderMenuClose: ImageView
    var token: String? = ""

    var dialog: Dialog? = null
    var id = 0
    var codeValue = "ENG"
    var codeDesc = "ENGLISH"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)

        toolbarinside = findViewById<View>(R.id.toolbarinside) as Toolbar
        setSupportActionBar(toolbarinside)
        supportActionBar?.title = ""
        //  globalVariable.pauseTime = 0;

        navigationView = findViewById<View>(R.id.navigation_viewin) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)


        drawerLayout = findViewById(R.id.drawer_layoutin)
        //navigationView = findViewById(R.id.navigation_viewin)
        val hView = navigationView.getHeaderView(0)
        imageViewHeaderMenuClose = hView.findViewById(R.id.closeHeader)
        imageViewHeaderMenuClose.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
        }

       // hideKeyboard()

        navigationView.itemIconTintList = null



        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController!!.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_notifications,
                R.id.navigation_account,
                R.id.navigation_settings
            )
        )
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        globalVariable = this.applicationContext as GlobalVariable
        globalVariable.pauseTime = 0;

        if (TextContants.banglaLanguageCode == globalVariable.languageCode) {
            val menu = bottomNavigationView.menu
            for (i in 0 until menu.size()) {
                val mi = menu.getItem(i)
                val id = mi.itemId
                if (id == R.id.navigation_home) {
                    mi.setTitle(R.string.title_home_bangla)
                } else if (id == R.id.navigation_notifications) {
                    mi.setTitle(R.string.title_notifications_bangla)
                } else if (id == R.id.navigation_account) {
                    mi.setTitle(R.string.title_account_bangla)
                } else if (id == R.id.navigation_settings) {
                    mi.setTitle(R.string.title_setting_bangla)
                }
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_home -> {
                // handle click
                // fragment = HomeFragment()

                findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_home)
                true
            }

            R.id.navigation_notifications -> {
                // handle click
                //fragment = NotificationsFragment()
                findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_notifications)
                true
            }
            R.id.navigation_account -> {
                // handle click
                // fragment = AccountFragment()
                // accountDialog()

                findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_account)
                true
            }
            R.id.navigation_settings -> {

                //fragment = SettingsFragment()
                findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_settings)

                true
            }

           /* R.id.logout_idin -> {
                //val intent = Intent(this, Login::class.java)
                //startActivity(intent)
                Custom_alert.logout(this, globalVariable.languageCode)
                drawerLayout.closeDrawers()

                true
            }
            R.id.aboutus_idin -> {
                val intent = Intent(this, AboutusActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.branch_location_idin -> {
                val intent = Intent(this, BranchLocationActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.atm_idin -> {
                val intent = Intent(this, ATMLocationActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.terms_and_condition_idin -> {
                val intent = Intent(this, TermsAndConditionsActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.language_settings_idin -> {
                showCustomDialog()
                drawerLayout.closeDrawers()

                true
            }
            R.id.contact_us_idin -> {
                val intent = Intent(this, ContactActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.notification_idin -> {
                val intent = Intent(this, NotificationActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.service_idin -> {
                val intent = Intent(this, ServiceActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.safetytips_idin -> {
                val intent = Intent(this, SafetyActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }
            R.id.tranlimit_idin -> {
                val intent = Intent(this, TransactionalLimitActivity::class.java)
                intent.putExtra("W", "W")
                startActivity(intent)
                drawerLayout.closeDrawers()

                true
            }*/

            else -> false
        }
/*
        if (fragment != null) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.nav_host_fragment, fragment)
            ft.commit()
        }
*/
        return true;
    }

}