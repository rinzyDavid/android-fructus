package com.david.fructus.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class to map with our database column
 */
@Entity(tableName = "fruits")
data class Fruit(
    @ColumnInfo(name = "title")
    var title:String?=null,
    @ColumnInfo(name = "headline")
    var headline:String?=null,
    @ColumnInfo(name = "fruit_image")
    var image:String?=null,
    @ColumnInfo(name = "gradient_color")
    var gradientColors:List<Color>?=null,
    var description:String?=null,
    var uses:String?=null,
    var nutrients:String?=null,
    var nutrition:List<Nutrients>?=null
    ){

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
