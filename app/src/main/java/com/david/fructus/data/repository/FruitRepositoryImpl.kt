package com.david.fructus.data.repository

import androidx.lifecycle.LiveData
import com.david.fructus.data.dao.FruitDao
import com.david.fructus.data.model.Fruit
import com.david.fructus.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FruitRepositoryImpl @Inject constructor(
   private val fruitDao: FruitDao,
   @IoDispatcher private val  dispatcher: CoroutineDispatcher = Dispatchers.IO
):FruitRepository {


    override fun listFruits(): LiveData<List<Fruit>> {
        return fruitDao.getFruits()
    }

    override suspend fun createFruit(fruit: Fruit) {
        withContext(dispatcher){
            fruitDao.insert(fruit)
        }

    }
}