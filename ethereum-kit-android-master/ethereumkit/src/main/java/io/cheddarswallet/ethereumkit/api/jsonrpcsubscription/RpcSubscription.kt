package io.cheddarswallet.ethereumkit.api.jsonrpcsubscription

import com.google.gson.Gson
import io.cheddarswallet.ethereumkit.api.core.RpcSubscriptionResponse

abstract class RpcSubscription<T>(val params: List<Any>) {
    protected abstract val typeOfResult: Class<T>

    fun parse(response: RpcSubscriptionResponse, gson: Gson): T {
        return gson.fromJson(response.params.result.toString(), typeOfResult)
    }
}
