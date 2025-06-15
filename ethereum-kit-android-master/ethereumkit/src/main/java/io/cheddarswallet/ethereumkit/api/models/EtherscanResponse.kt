package io.cheddarswallet.ethereumkit.api.models

data class EtherscanResponse(
        val status: String,
        val message: String,
        val result: List<Map<String, String>>
)
