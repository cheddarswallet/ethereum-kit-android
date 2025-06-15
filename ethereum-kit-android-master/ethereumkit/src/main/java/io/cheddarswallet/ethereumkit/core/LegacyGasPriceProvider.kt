package io.cheddarswallet.ethereumkit.core

import io.cheddarswallet.ethereumkit.api.jsonrpc.GasPriceJsonRpc
import io.reactivex.Single

class LegacyGasPriceProvider(
        private val evmKit: EthereumKit
) {
    fun gasPriceSingle(): Single<Long> {
        return evmKit.rpcSingle(GasPriceJsonRpc())
    }
}
