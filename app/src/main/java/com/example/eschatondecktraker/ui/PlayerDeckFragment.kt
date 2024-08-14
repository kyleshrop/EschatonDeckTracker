package com.example.eschatondecktraker.ui

import Hand
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eschatondecktraker.NeutralDeck
import com.example.eschatondecktraker.R
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.databinding.PlayerDeckFregmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PlayerDeckFragment : Fragment() {

    private val neutralDeck = NeutralDeck()
    private val hand =Hand()

    private var _binding: PlayerDeckFregmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PlayerDeckFregmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val combinedCards: List<Card> = hand.cultistCardsInHand + hand.monsterCardsInHand
        val adapter = PlayerHandAdapter(combinedCards)
        binding.playerHandRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.playerHandRecyclerView.adapter = adapter

        binding.buttonConclave.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonBook.setOnClickListener {
            hand.addRandomMonsterCard()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}