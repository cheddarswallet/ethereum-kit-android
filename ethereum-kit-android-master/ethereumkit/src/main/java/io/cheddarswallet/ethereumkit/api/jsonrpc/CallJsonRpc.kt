package io.cheddarswallet.ethereumkit.api.jsonrpc

import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.DefaultBlockParameter

class CallJsonRpc(
        @Transient val contractAddress: Address,
        @Transient val data: ByteArray,
        @Transient val defaultBlockParameter: DefaultBlockParameter
) : DataJsonRpc(
        method = "eth_call",
        params = listOf(mapOf("to" to contractAddress, "data" to data), defaultBlockParameter)
)
