package com.example.dynamicView.utils

sealed class ApiResponses <out T>{

    data class Success<out R>(val data : R): ApiResponses<R>()
    data class Failure(val msg : String): ApiResponses<Nothing>()
    object Loading : ApiResponses<Nothing>()

}