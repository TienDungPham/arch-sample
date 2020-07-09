package com.tiendungpham.archsamples.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tiendungpham.archsamples.GuessWordApplication
import com.tiendungpham.archsamples.R
import com.tiendungpham.archsamples.dagger.DaggerAppComponent
import com.tiendungpham.archsamples.databinding.FragmentGameBinding
import com.tiendungpham.core.data.Word
import javax.inject.Inject

class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding
    lateinit var wordList: List<Word>

    @Inject
    lateinit var gameViewModelFactory: GameViewModelFactory

    private val gameViewModel by viewModels<GameViewModel> {
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

        binding.nextBtn.isEnabled = false
        binding.nextBtn.setOnClickListener {
            gameViewModel.onNextWord()
        }

        binding.skipBtn.isEnabled = false
        binding.skipBtn.setOnClickListener {
            gameViewModel.onSkipWord()
        }

        binding.word.text = "Loading!!!"
        gameViewModel.currentWord.observe(viewLifecycleOwner, Observer {
            binding.nextBtn.isEnabled = true
            binding.skipBtn.isEnabled = true
            binding.word.text = it.title.toString()
        })

        gameViewModel.gameFinished.observe(viewLifecycleOwner, Observer {
            if (it) {
                val bundle = Bundle()
                bundle.putInt("totalScore", gameViewModel.totalScore.value ?: 0)
                findNavController().navigate(R.id.action_gameFragment_to_scoreFragment, bundle)
            }
        })
    }
}