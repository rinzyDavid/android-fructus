package com.david.fructus.work

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.david.fructus.R
import com.david.fructus.data.db.FruitDatabase
import com.david.fructus.data.model.Fruit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A worker that will help populate the database on app first installation.
 */
class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
         applicationContext.resources.openRawResource(R.raw.fruits)
             .use {inputStream ->
                 JsonReader(inputStream.reader()).use { jsonReader ->
                     val fruitType = object : TypeToken<List<Fruit>>() {}.type
                     val fruitList: List<Fruit> = Gson().fromJson(jsonReader, fruitType)

                     val database = FruitDatabase.getInstance(applicationContext)
                     database.fruitDao().insertAll(fruitList)
                     Result.success()
                 }
             }

        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
    }

}