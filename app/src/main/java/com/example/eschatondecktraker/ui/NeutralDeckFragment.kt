package com.example.eschatondecktraker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.data.MonsterCardBase
import com.example.eschatondecktraker.data.PlayerDeck
import com.example.eschatondecktraker.databinding.FragmentNeutralDeckBinding

class NeutralDeckFragment : Fragment() {
    private var _binding: FragmentNeutralDeckBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerDeck: PlayerDeck
    private lateinit var adapter: DeckCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNeutralDeckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        playerDeck = PlayerDeck.getInstance()
        
        val monsterCards = MonsterCardBase.MonsterName.values()
            .map { MonsterCardBase.create(it) }
        
        adapter = DeckCardAdapter(monsterCards) { card ->
            if (!isMonsterAlreadyOwned(card)) {
                playerDeck.addCard(card)
                updateDisabledCards()
                Toast.makeText(requireContext(), "${getCardName(card)} added to deck!", Toast.LENGTH_SHORT).show()
            }
        }
        
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.adapter = adapter
        
        updateDisabledCards()
    }
    
    private fun isMonsterAlreadyOwned(card: Card): Boolean {
        return playerDeck.getAllCards().any { 
            it.monsterName == card.monsterName 
        }
    }
    
    private fun updateDisabledCards() {
        val ownedMonsters = playerDeck.getAllCards()
            .filter { it.monsterName != null }
            .toSet()
        adapter.setDisabledCards(ownedMonsters)
    }
    
    private fun getCardName(card: Card): String {
        return when {
            card.cultistName != null -> card.cultistName.name.replace("_", " ")
            card.monsterName != null -> card.monsterName.name.replace("_", " ")
            else -> "Unknown"
        }
    }
    
    override fun onResume() {
        super.onResume()
        updateDisabledCards()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}