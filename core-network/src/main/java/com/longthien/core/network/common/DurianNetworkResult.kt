package com.longthien.core.network.common

import java.lang.Exception

sealed interface DurianNetworkResult<out T> {
    data class Success<T>(val data: T) : DurianNetworkResult<T>

    data class Error(val exception: Throwable) : DurianNetworkResult<Nothing>
}
