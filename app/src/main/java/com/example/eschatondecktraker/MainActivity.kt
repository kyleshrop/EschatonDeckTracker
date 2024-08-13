package com.example.eschatondecktraker

import Hand
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.eschatondecktraker.data.CultistCardBase
import com.example.eschatondecktraker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val initiateCard = CultistCardBase.Card.create(CultistCardBase.CultistName.Initiate)
    private val acolyteCard = CultistCardBase.Card.create(CultistCardBase.CultistName.Acolyte)
    private val fanaticCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Fanatic)

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val deck = NeutralDeck()
        val hand = Hand()

        // Deal the user the starting hand
        repeat(3) {
            deck.drawCard()?.let { hand.addCultistCard(initiateCard) }
        }
        repeat(3){
            deck.drawCard()?.let { hand.addCultistCard(fanaticCard) }
        }
        deck.drawCard()?.let { hand.addCultistCard(acolyteCard) }


        // Show the cards in hand
        println("Hand: ${hand.showHand()}")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}