package com.david.fructus.utilities

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("loadImageByName")
fun loadImage(view:View, name:String){

    Glide.with(view.context)
        .load(getImage(view.context,name))
            .into(view as ImageView);
}

fun getImage(context: Context,imageName: String?):Int {
    return context.resources.getIdentifier(imageName, "drawable", context.packageName)
}