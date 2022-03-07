package com.example.modularusingdynamicview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.modularusingdynamicview.R
import com.example.modularusingdynamicview.model.Response.RandomCocktailResponse
import kotlinx.android.synthetic.main.item_layout.view.*

class CategoryAdapter (val randomCocktailResponse: RandomCocktailResponse):RecyclerView.Adapter<CategoryAdapter.MainViewHolder>() {

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.apply {
            val list = randomCocktailResponse.drinks[position]
            list_item.text = list.strCategory

            setOnClickListener {
                Toast.makeText(context, "${list.strCategory}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
      return randomCocktailResponse.drinks.size
    }
}