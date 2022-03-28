package com.david.fructus.ui.fruitlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.david.fructus.R
import com.david.fructus.databinding.FragmentFruitListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [FruitListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class FruitListFragment : Fragment() {

      val viewModel:FruitListVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = FragmentFruitListBinding.inflate(inflater,container,false)
        viewModel.fetchFruits().observe(viewLifecycleOwner) {

            println(it)
            val adapter = FruitListAdapter(it)
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