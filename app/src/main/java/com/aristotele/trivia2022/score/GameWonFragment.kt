package com.aristotele.trivia2022.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.aristotele.trivia2022.R
import com.aristotele.trivia2022.databinding.FragmentGameOverBinding
import com.aristotele.trivia2022.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    private lateinit var binding: FragmentGameWonBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_over, container, false)

        //val binding: ViewDataBinding? = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)
        binding.buttonNextGame.setOnClickListener() {
            val action = GameWonFragmentDirections.actionGameWonFragmentToGameFragment()
            findNavController().navigate(action)

        }

        return binding.root
    }
}