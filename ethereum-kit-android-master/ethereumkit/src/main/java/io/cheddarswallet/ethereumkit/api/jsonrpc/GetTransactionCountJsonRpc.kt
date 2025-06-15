package io.cheddarswallet.ethereumkit.api.jsonrpc

import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.DefaultBlockParameter

class GetTransactionCountJsonRpc(
        @Transient val address: Address,
        @Transient val defaultBlockParameter: DefaultBlockParameter
) : LongJsonRpc(
        method = "eth_getTransactionCount",
        params = listOf(address, defaultBlockParameter)
)
