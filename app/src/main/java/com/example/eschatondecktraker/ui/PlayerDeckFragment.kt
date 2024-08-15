package com.example.eschatondecktraker.ui

import CultistDeck
import Hand
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eschatondecktraker.databinding.PlayerDeckFregmentBinding
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.data.CultistCardBase

class PlayerDeckFragment : Fragment() {

    private var _binding: PlayerDeckFregmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var playerHandAdapter: PlayerHandAdapter
    private lateinit var playerDeck: List<Card>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PlayerDeckFregmentBinding.inflate(inflater, container, false)


        val deck = CultistDeck()
        val playerDeck = Hand()

        repeat(3) {
            deck.dealCard()?.let { playerDeck.addCultistCard(initiateCard) }
        }
        repeat(3){
            deck.dealCard()?.let { playerDeck.addCultistCard(fanaticCard) }
        }
        deck.dealCard()?.let { playerDeck.addCultistCard(acolyteCard) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerDeck = Hand()

        playerHandAdapter = PlayerHandAdapter(playerDeck.showHand())

        binding.playerHandRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = playerHandAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val initiateCard = CultistCardBase.create(CultistCardBase.CultistName.Initiate)
    private val acolyteCard = CultistCardBase.create(CultistCardBase.CultistName.Acolyte)
    private val fanaticCard= CultistCardBase.create(CultistCardBase.CultistName.Fanatic)
}
