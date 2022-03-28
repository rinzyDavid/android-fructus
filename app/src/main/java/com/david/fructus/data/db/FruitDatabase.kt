package com.david.fructus.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.david.fructus.data.converter.ListConverter
import com.david.fructus.data.dao.FruitDao
import com.david.fructus.data.model.Fruit
import com.david.fructus.work.SeedDatabaseWorker

@Database(entities = [Fruit::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class FruitDatabase : RoomDatabase() {

    abstract fun fruitDao(): FruitDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: FruitDatabase? = null

        fun getInstance(context: Context): FruitDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }




        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): FruitDatabase {
            return Room.databaseBuilder(context, FruitDatabase::class.java, "fruitdb")
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                //.setInputData(workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)


                        }
                    }
                )
                .build()
        }


    }


}

