package com.example.eschatondecktraker

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.eschatondecktraker.data.PlayerDeck
import com.example.eschatondecktraker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
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
            R.id.action_settings -> true
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
        PlayerDeck.getInstance().clearDeck()
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
}