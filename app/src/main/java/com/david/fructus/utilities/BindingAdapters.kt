package com.david.fructus.utilities

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.ThemeCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.david.fructus.R
import com.david.fructus.data.model.Color

/**
 * Utility custom binding Adapters to enhance the capability of UI widgets
 */

@BindingAdapter("loadImageByName")
fun loadImage(view:View, name:String){

    Glide.with(view.context)
        .load(getResourceByName(view.context,name,"drawable"))
            .into(view as ImageView);
}

@BindingAdapter("colorName")
fun loadColorByName(view:View,color:String){
    val drawableName = color+"_gradient"
    view.background = AppCompatResources.getDrawable(view.context, getResourceByName(view.context,drawableName,"drawable"))
}

@BindingAdapter("textColorByName")
fun setTextColorByName(view:TextView,name:String){
    val colorName = "color_"+name+"_dark"
    view.setTextColor(ContextCompat.getColor(view.context, getResourceByName(view.context,colorName.lowercase(),"color")))
}

fun getResourceByName(context: Context,imageName: String?,type:String):Int {
    return context.resources.getIdentifier(imageName, type, context.packageName)
}