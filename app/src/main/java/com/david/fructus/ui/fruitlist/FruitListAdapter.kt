package com.david.fructus.ui.fruitlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.fructus.data.model.Fruit
import com.david.fructus.databinding.LayoutFruitListItemBinding

class FruitListAdapter(
    private val fruits:List<Fruit>,
    private val listener:ClickListener
):RecyclerView.Adapter<FruitListAdapter.CustomViewHolder>() {

    interface ClickListener{
        fun onFruitSelected(fruit: Fruit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        return CustomViewHolder(
            LayoutFruitListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       holder.bind(fruits[position])
        holder.itemView.setOnClickListener {
            listener.onFruitSelected(fruits[position])
        }
    }

    override fun getItemCount(): Int {
       return fruits.size
    }





    class CustomViewHolder(
    private val binding:LayoutFruitListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(fruit: Fruit){
        binding.fruit = fruit
    }
}


}