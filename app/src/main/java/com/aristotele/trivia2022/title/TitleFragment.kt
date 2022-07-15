package com.aristotele.trivia2022.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.aristotele.trivia2022.R
import com.aristotele.trivia2022.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
            // 2 مورد باید در گریدر اضافه بشه وگرنه آدرس دهی رو نمیشناسه
            binding.buttonGotoGame.setOnClickListener {

                val actionLocal = TitleFragmentDirections.actionTitleFragmentToGameFragment()
                findNavController().navigate (actionLocal)
            }
            return binding.root
        }

}