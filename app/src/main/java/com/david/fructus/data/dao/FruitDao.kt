package com.david.fructus.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.david.fructus.data.model.Fruit

@Dao
interface FruitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fruit:Fruit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(fruits:List<Fruit>)

    @Update
    fun update(fruit: Fruit)

    @Query("select * from fruits")
    fun getFruits():LiveData<List<Fruit>>
}