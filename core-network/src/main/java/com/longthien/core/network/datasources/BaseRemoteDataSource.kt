package com.longthien.core.network.datasources

import com.longthien.core.network.common.DurianNetworkResult
import com.longthien.core.network.entities.DurianNetworkException
import retrofit2.Response

open class BaseRemoteDataSources {
    protected suspend fun <T : Any> callApi(call: suspend () -> Response<T>): DurianNetworkResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (e: Exception) {
            return DurianNetworkResult.Error(exception = e)
        }
        if (response.isSuccessful) {

            response.body()?.let {
                return DurianNetworkResult.Success(it)
            } ?: run {
                return DurianNetworkResult.Error(exception = Exception("Body is empty"))
            }

        } else {
            val responseError = response.errorBody()?.toString()?.let {

                val durianNetworkException = DurianNetworkException()
                durianNetworkException.parse(it)
                return DurianNetworkResult.Error(durianNetworkException)

            } ?: run {
                return DurianNetworkResult.Error(exception = Exception(response.message()))
            }
        }
    }
}