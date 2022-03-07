package com.example.modularusingdynamicview.viewModel

import androidx.lifecycle.ViewModel
import com.example.modularusingdynamicview.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(val mainRepo : MainRepo): ViewModel() {

    fun categoryData(list: String) =
        mainRepo.categoryData(list)
}