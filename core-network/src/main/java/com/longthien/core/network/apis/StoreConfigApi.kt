package com.longthien.core.network.apis

import com.longthien.core.network.entities.StoreConfigRemote
import retrofit2.Response
import retrofit2.http.GET

interface StoreConfigApi {
    @GET("/V1/store/storeConfigs")
    suspend fun getStoreConfig(): Response<List<StoreConfigRemote>>         //Return array -> List
}