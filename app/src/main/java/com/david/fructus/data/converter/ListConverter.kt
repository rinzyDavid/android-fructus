package com.david.fructus.data.converter

import androidx.room.TypeConverter
import com.david.fructus.data.model.Color
import com.david.fructus.data.model.Nutrients
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Data converters. This helps to convert lists to string and back. to save in Room database.
 */

class ListConverter {

    @TypeConverter
    fun fromColorList(value: List<Color>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Color>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toColorList(value: String): List<Color> {
        val gson = Gson()
        val type = object : TypeToken<List<Color>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun formNutrientList(value:List<Nutrients>):String{
        val gson = Gson()
        val type = object : TypeToken<List<Nutrients>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toNutrientList(value:String):List<Nutrients>{
        val gson = Gson()
        val type = object : TypeToken<List<Nutrients>>() {}.type
        return gson.fromJson(value, type)
    }
}