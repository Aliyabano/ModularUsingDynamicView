package com.example.dynamicView.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

fun <T> result(call: suspend () -> Response<T>): Flow<ApiResponses<T?>> = flow {

    emit(ApiResponses.Loading)
    try {
        val c = call()
        c.let {
            if (it.isSuccessful) {
                emit(ApiResponses.Success(it.body()))
            } else {
                c.errorBody()?.let { error ->
                    error.close()
                    emit(ApiResponses.Failure(error.toString()))
                }
            }
        }
    } catch (t: Throwable) {
        t.printStackTrace()
        emit(ApiResponses.Failure("${t.message}"))
    }
}
