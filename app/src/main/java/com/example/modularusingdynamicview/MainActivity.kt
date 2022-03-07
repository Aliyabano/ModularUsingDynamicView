package com.example.modularusingdynamicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dynamicView.utils.ApiResponses
import com.example.modularusingdynamicview.adapter.CategoryAdapter
import com.example.modularusingdynamicview.model.Response.RandomCocktailResponse
import com.example.modularusingdynamicview.viewModel.MainVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainVM : MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = "List"
        categoryData(list)
    }
    private fun categoryData(list: String) {
        lifecycleScope.launchWhenStarted {
            mainVM.categoryData(list).collect {
                when (it){
                    is ApiResponses.Failure ->
                        Log.e("MainActivity","${it.msg}")
                    ApiResponses.Loading -> {

                    }
                    is ApiResponses.Success -> {
                        Log.e("Response","${it.data!!.drinks}")
                        val cAdapter = CategoryAdapter(it.data!!)
                        main_rv.layoutManager = LinearLayoutManager(this@MainActivity)
                        main_rv.adapter = cAdapter

                    }
                }
            }
        }

    }
}