package io.cheddarswallet.ethereumkit.api.jsonrpc

class SubscribeJsonRpc(
        params: List<Any>
) : JsonRpc<String>("eth_subscribe", params) {
    @Transient
    override val typeOfResult = String::class.java
}
