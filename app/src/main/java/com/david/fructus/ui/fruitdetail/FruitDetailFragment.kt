package com.david.fructus.ui.fruitdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.david.fructus.R
import com.david.fructus.databinding.FragmentFruitDetailBinding
import com.david.fructus.viewmodel.FruitListVM


/**
 * A simple [Fragment] subclass.
 * Use the [FruitDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FruitDetailFragment : Fragment() {

    val viewModel: FruitListVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentFruitDetailBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment FruitDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            FruitDetailFragment()
    }
}