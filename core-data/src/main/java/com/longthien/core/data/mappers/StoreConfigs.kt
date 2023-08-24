package com.longthien.core.data.mappers

import com.longthien.core.model.StoreConfig
import com.longthien.core.network.entities.StoreConfigRemote

fun StoreConfigRemote.toModel(): StoreConfig {
    return StoreConfig(
        baseMediaUrl = baseMediaUrl,
        secureBaseMediaUrl = secureBaseMediaUrl,
        baseUrl = baseUrl,
        secureBaseUrl = secureBaseUrl,
        code = code
    )
}