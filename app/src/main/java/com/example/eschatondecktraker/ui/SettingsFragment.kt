package com.example.eschatondecktraker.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eschatondecktraker.R
import com.example.eschatondecktraker.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var sharedPreferences: SharedPreferences
    
    companion object {
        const val PREFS_NAME = "EschatonDeckTrackerPrefs"
        const val KEY_THEME_MODE = "theme_mode"
        const val KEY_DRAFT_MODE = "draft_mode"
        const val THEME_LIGHT = "light"
        const val THEME_DARK = "dark"
        const val THEME_SYSTEM = "system"
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        sharedPreferences = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        
        setupThemeControls()
        setupDraftModeControls()
        setupBackButton()
    }
    
    private fun setupThemeControls() {
        val currentTheme = sharedPreferences.getString(KEY_THEME_MODE, THEME_SYSTEM) ?: THEME_SYSTEM
        
        // Set initial radio button selection
        when (currentTheme) {
            THEME_LIGHT -> binding.radioLight.isChecked = true
            THEME_DARK -> binding.radioDark.isChecked = true
            THEME_SYSTEM -> binding.radioSystem.isChecked = true
        }
        
        // Set up radio group listener
        binding.themeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedTheme = when (checkedId) {
                R.id.radio_light -> THEME_LIGHT
                R.id.radio_dark -> THEME_DARK
                R.id.radio_system -> THEME_SYSTEM
                else -> THEME_SYSTEM
            }
            
            // Save preference
            sharedPreferences.edit().putString(KEY_THEME_MODE, selectedTheme).apply()
            
            // Apply theme immediately
            applyTheme(selectedTheme)
        }
    }
    
    private fun setupDraftModeControls() {
        val isDraftMode = sharedPreferences.getBoolean(KEY_DRAFT_MODE, false)
        
        // Set initial switch state
        binding.draftModeSwitch.isChecked = isDraftMode
        
        // Set up switch listener
        binding.draftModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Save preference
            sharedPreferences.edit().putBoolean(KEY_DRAFT_MODE, isChecked).apply()
        }
    }
    
    private fun setupBackButton() {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    
    private fun applyTheme(theme: String) {
        val mode = when (theme) {
            THEME_LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
            THEME_DARK -> AppCompatDelegate.MODE_NIGHT_YES
            THEME_SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}