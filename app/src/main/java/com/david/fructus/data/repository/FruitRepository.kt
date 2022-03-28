package com.david.fructus.data.repository

import androidx.lifecycle.LiveData
import com.david.fructus.data.model.Fruit

interface FruitRepository {

    fun listFruits():LiveData<List<Fruit>>
    suspend fun createFruit(fruit: Fruit)
}