package com.longthien.core.data.mappers

import com.longthien.core.model.Currency
import com.longthien.core.network.entities.CurrencyRemote

fun CurrencyRemote.toModel(): Currency {
    return Currency(
        baseCurrencyCode = baseCurrencyCode,
        baseCurrencySymbol = baseCurrencySymbol
    )
}