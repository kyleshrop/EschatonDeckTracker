package com.example.eschatondecktraker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.eschatondecktraker.data.PlayerDeck
import com.example.eschatondecktraker.databinding.ActivityMainBinding
import com.example.eschatondecktraker.ui.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply saved theme before calling super.onCreate
        applyThemeFromPreferences()
        
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        try {
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            appBarConfiguration = AppBarConfiguration(navController.graph)
            setupActionBarWithNavController(navController, appBarConfiguration)
        } catch (e: IllegalStateException) {
            // NavController not ready yet, this can happen during initialization
            // The navigation will still work, just without the up button support
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_deck -> {
                showClearDeckConfirmation()
                true
            }
            R.id.action_settings -> {
                try {
                    val navController = findNavController(R.id.nav_host_fragment_content_main)
                    navController.navigate(R.id.action_HomeFragment_to_SettingsFragment)
                } catch (e: Exception) {
                    // Navigation might fail, that's okay
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    private fun showClearDeckConfirmation() {
        AlertDialog.Builder(this)
            .setTitle(R.string.clear_deck_confirmation_title)
            .setMessage(R.string.clear_deck_confirmation_message)
            .setPositiveButton(R.string.clear) { _, _ ->
                clearPlayerDeck()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
    
    private fun clearPlayerDeck() {
        PlayerDeck.getInstance(this).clearDeck()
        // Navigate to home if not already there to refresh the UI
        try {
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            navController.navigate(R.id.HomeFragment)
        } catch (e: Exception) {
            // Navigation might fail if already on home or during transitions, that's okay
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return try {
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        } catch (e: IllegalStateException) {
            super.onSupportNavigateUp()
        }
    }
    
    private fun applyThemeFromPreferences() {
        val sharedPreferences = getSharedPreferences(SettingsFragment.PREFS_NAME, Context.MODE_PRIVATE)
        val savedTheme = sharedPreferences.getString(SettingsFragment.KEY_THEME_MODE, SettingsFragment.THEME_SYSTEM) ?: SettingsFragment.THEME_SYSTEM
        
        val mode = when (savedTheme) {
            SettingsFragment.THEME_LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
            SettingsFragment.THEME_DARK -> AppCompatDelegate.MODE_NIGHT_YES
            SettingsFragment.THEME_SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}