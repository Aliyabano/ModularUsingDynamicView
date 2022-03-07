package com.example.modularusingdynamicview.model.Response


import com.google.gson.annotations.SerializedName

data class RandomCocktailResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>
) {
    data class Drink(
        @SerializedName("strCategory")
        val strCategory: String
    )
}