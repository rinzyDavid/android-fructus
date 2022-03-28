package com.david.fructus.ui.fruitlist

import androidx.lifecycle.ViewModel
import com.david.fructus.data.repository.FruitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FruitListVM @Inject constructor(
    private val fruitRepository: FruitRepository
): ViewModel() {

    fun fetchFruits() = fruitRepository.listFruits()

}