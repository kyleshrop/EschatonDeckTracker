package com.example.eschatondecktraker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eschatondecktraker.R
import com.example.eschatondecktraker.data.PlayerDeck
import com.example.eschatondecktraker.databinding.FragmentPlayerDeckBinding

class PlayerDeckFragment : Fragment() {
    private var _binding: FragmentPlayerDeckBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerDeck: PlayerDeck
    private lateinit var adapter: PlayerDeckAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDeckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        playerDeck = PlayerDeck.getInstance()
        
        adapter = PlayerDeckAdapter { card ->
            card.isDrawn = !card.isDrawn
            adapter.notifyDataSetChanged()
        }
        
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_PlayerDeckFragment_to_HomeFragment)
        }
        
        binding.btnReshuffle.setOnClickListener {
            playerDeck.reshuffleAll()
            adapter.updateCards(playerDeck.getAllCards())
        }
        
        adapter.updateCards(playerDeck.getAllCards())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
