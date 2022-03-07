package com.example.modularusingdynamicview.repository

import com.example.dynamicView.network.RetrofitServices
import com.example.dynamicView.utils.result
import javax.inject.Inject

class MainRepo @Inject constructor(val retrofitServices: RetrofitServices ){

    fun categoryData(list: String) = result {
        retrofitServices.categoryList(list)
    }
}