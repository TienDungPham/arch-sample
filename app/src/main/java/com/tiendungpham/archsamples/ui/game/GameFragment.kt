package com.tiendungpham.archsamples.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tiendungpham.archsamples.GuessWordApplication
import com.tiendungpham.archsamples.R
import com.tiendungpham.archsamples.dagger.DaggerAppComponent
import com.tiendungpham.archsamples.databinding.FragmentGameBinding
import javax.inject.Inject

class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding

    @Inject
    lateinit var gameViewModelFactory: GameViewModelFactory

    private val viewModel by viewModels<GameViewModel> {
        gameViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.builder()
            .setCoreComponent(GuessWordApplication.coreComponent(this.requireContext()))
            .build()
            .injectGame(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setupWithNavController(findNavController())
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_scoreFragment)
        }
        binding.skipBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_scoreFragment)
        }
    }
}