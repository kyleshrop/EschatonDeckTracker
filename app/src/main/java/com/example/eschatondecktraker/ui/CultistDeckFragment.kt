package com.example.eschatondecktraker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.data.CultistCardBase
import com.example.eschatondecktraker.data.PlayerDeck
import com.example.eschatondecktraker.databinding.FragmentCultistDeckBinding

class CultistDeckFragment : Fragment() {
    private var _binding: FragmentCultistDeckBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerDeck: PlayerDeck
    private lateinit var adapter: DeckCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCultistDeckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        playerDeck = PlayerDeck.getInstance()
        
        val cultistCards = CultistCardBase.CultistName.values()
            .filter { it != CultistCardBase.CultistName.Null }
            .map { CultistCardBase.create(it) }
        
        adapter = DeckCardAdapter(cultistCards) { card ->
            playerDeck.addCard(card)
            Toast.makeText(requireContext(), "${getCardName(card)} added to deck!", Toast.LENGTH_SHORT).show()
        }
        
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.adapter = adapter
    }
    
    private fun getCardName(card: Card): String {
        return when {
            card.cultistName != null -> card.cultistName.name.replace("_", " ")
            card.monsterName != null -> card.monsterName.name.replace("_", " ")
            else -> "Unknown"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}