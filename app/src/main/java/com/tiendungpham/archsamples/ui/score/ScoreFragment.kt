package com.tiendungpham.archsamples.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tiendungpham.archsamples.R
import com.tiendungpham.archsamples.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
    lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setupWithNavController(findNavController())
        binding.stopBtn.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_welcomeFragment)
        }
        arguments?.apply {
            binding.score.text = "Your score: ${getInt("totalScore")}"
        }
    }
}