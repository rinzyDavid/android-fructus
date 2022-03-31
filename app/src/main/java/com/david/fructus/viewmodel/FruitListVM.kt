package com.david.fructus.viewmodel

import androidx.lifecycle.ViewModel
import com.david.fructus.data.model.Fruit
import com.david.fructus.data.repository.FruitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FruitListVM @Inject constructor(
    private val fruitRepository: FruitRepository
): ViewModel() {

    var selectedFruit:Fruit?=null
    fun fetchFruits() = fruitRepository.listFruits()

}