package com.example.eschatondecktraker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eschatondecktraker.R
import com.example.eschatondecktraker.data.PlayerDeck
import com.example.eschatondecktraker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerDeck: PlayerDeck

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        playerDeck = PlayerDeck.getInstance(requireContext())
        
        binding.btnViewDeck.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_PlayerDeckFragment)
        }
        
        binding.btnCultistDeck.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_CultistDeckFragment)
        }
        
        binding.btnNeutralDeck.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_NeutralDeckFragment)
        }
    }
    
    override fun onResume() {
        super.onResume()
        updateStats()
    }
    
    private fun updateStats() {
        val stats = playerDeck.getTotalStats()
        binding.tvZeal.text = "Zeal: ${stats.zeal}"
        binding.tvDivination.text = "Divination: ${stats.divination}"
        binding.tvInfluence.text = "Influence: ${stats.influence}"
        binding.tvAggression.text = "Aggression: ${stats.aggression}"
        binding.tvScour.text = "Scour: ${stats.scour}"
        binding.tvInspire.text = "Inspire: ${stats.inspire}"
        binding.tvPointValue.text = "Point Value: ${stats.pointValue}"
        binding.tvTotalCards.text = "Cards Remaining: ${stats.totalCards}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}