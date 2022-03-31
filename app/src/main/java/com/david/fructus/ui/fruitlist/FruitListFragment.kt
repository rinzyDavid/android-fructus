package com.david.fructus.ui.fruitlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.david.fructus.R
import com.david.fructus.data.model.Fruit
import com.david.fructus.databinding.FragmentFruitListBinding
import com.david.fructus.viewmodel.FruitListVM
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [FruitListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class FruitListFragment : Fragment() {

      val viewModel: FruitListVM by activityViewModels()

    private val listListener = object:FruitListAdapter.ClickListener{
        override fun onFruitSelected(fruit: Fruit) {
            viewModel.selectedFruit = fruit
            findNavController().navigate(R.id.action_fruitListFragment_to_fruitDetailFragment)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = FragmentFruitListBinding.inflate(inflater,container,false)
        viewModel.fetchFruits().observe(viewLifecycleOwner) {


            val adapter = FruitListAdapter(it,listListener)
            binding.fruitList.adapter = adapter
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FruitListFragment()
    }
}