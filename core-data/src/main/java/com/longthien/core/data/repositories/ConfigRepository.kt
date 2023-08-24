package com.longthien.core.data.repositories

import com.longthien.core.common.IoDispatcher
import com.longthien.core.data.mappers.toModel
import com.longthien.core.model.Currency
import com.longthien.core.model.StoreConfig
import com.longthien.core.network.common.DurianNetworkResult
import com.longthien.core.network.datasources.ConfigRemoteDataSources
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ConfigRepository {
    suspend fun getCurrency(): Currency

    suspend fun getStoreConfig(): List<StoreConfig>
}

class ConfigRepositoryImpl @Inject constructor(
    private val configRemoteDataSources: ConfigRemoteDataSources,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ConfigRepository {
    override suspend fun getCurrency(): Currency = withContext(dispatcher) {
        when (val result = configRemoteDataSources.getCurrency()) {
            is DurianNetworkResult.Success -> {
                result.data.toModel()
            }

            is DurianNetworkResult.Error -> {
                throw result.exception
            }
        }
    }

    override suspend fun getStoreConfig(): List<StoreConfig> = withContext(dispatcher) {
        when (val result = configRemoteDataSources.getStoreConfig()) {
            is DurianNetworkResult.Success -> {
                result.data.map { it.toModel() }
            }

            is DurianNetworkResult.Error -> {
                throw result.exception
            }
        }
    }

}