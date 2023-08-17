package com.longthien.core.network.datasources

import com.longthien.core.network.apis.CurrencyApi
import com.longthien.core.network.apis.StoreConfigApi
import com.longthien.core.network.common.DurianNetworkResult
import com.longthien.core.network.entities.CurrencyRemote
import com.longthien.core.network.entities.StoreConfigRemote
import javax.inject.Inject

interface ConfigRemoteDataSources {

    suspend fun getCurrency(): DurianNetworkResult<CurrencyRemote>

    suspend fun getStoreConfig(): DurianNetworkResult<List<StoreConfigRemote>>


}

class ConfigRemoteDataSourcesImpl @Inject constructor(
    private val currencyApi: CurrencyApi,
    private val storeConfigApi: StoreConfigApi
) : BaseRemoteDataSources(), ConfigRemoteDataSources {
    override suspend fun getCurrency(): DurianNetworkResult<CurrencyRemote> {
        return callApi {
            currencyApi.getCurrency()
        }
    }

    override suspend fun getStoreConfig(): DurianNetworkResult<List<StoreConfigRemote>> {
        return callApi {
            storeConfigApi.getStoreConfig()
        }
    }

}