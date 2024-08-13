package com.example.eschatondecktraker.ui

import CultistDeck
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.eschatondecktraker.R
import com.example.eschatondecktraker.data.CultistCardBase
import com.example.eschatondecktraker.databinding.ConclaveStoreFragmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ConclaveStoreFragment : Fragment() {

    private var _binding: ConclaveStoreFragmentBinding? = null

    private val cultistDeck = CultistDeck()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ConclaveStoreFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setting up the grid
        val gridLayout = view.findViewById<GridLayout>(R.id.cultist_grid)

        for (i in 0 until gridLayout.childCount) {
            val gridItem = gridLayout.getChildAt(i) as Button
            val card = cultistDeck.getCardAtIndex(i) // Method to get card at a specific index

            gridItem.text = card.cultistName.toString()
            gridItem.setOnClickListener {
                selectCultistCard(card)
            }


            binding.buttonSecond.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }

            binding.buttonAddToDeck.setOnClickListener {
                //TODO:
                // Logic to add the selected card to the player's deck
            }
        }
    }
        fun selectCultistCard(card: CultistCardBase.Card) {
            // Handle the card selection logic here
            Toast.makeText(context, "Selected: ${card.cultistName}", Toast.LENGTH_SHORT).show()
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}