package io.cheddarswallet.ethereumkit.core

import io.cheddarswallet.ethereumkit.api.core.IRpcApiProvider
import io.cheddarswallet.ethereumkit.api.core.RpcBlockchain
import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.DefaultBlockParameter
import io.cheddarswallet.ethereumkit.models.RpcSource
import io.cheddarswallet.ethereumkit.spv.core.toBigInteger
import io.reactivex.Single
import java.math.BigInteger

class Eip1155Provider(
    private val provider: IRpcApiProvider
) {

    class BalanceOfMethod(val owner: Address, val tokenId: BigInteger) : ContractMethod() {
        override val methodSignature = "balanceOf(address,uint256)"
        override fun getArguments() = listOf(owner, tokenId)
    }

    fun getTokenBalance(contractAddress: Address, tokenId: BigInteger, address: Address): Single<BigInteger> {
        val callRpc = RpcBlockchain.callRpc(contractAddress, BalanceOfMethod(address, tokenId).encodedABI(), DefaultBlockParameter.Latest)

        return provider
            .single(callRpc)
            .map { it.sliceArray(IntRange(0, 31)).toBigInteger() }
    }

    companion object {

        fun instance(rpcSource: RpcSource.Http): Eip1155Provider {
            val apiProvider = RpcApiProviderFactory.nodeApiProvider(rpcSource)

            return Eip1155Provider(apiProvider)
        }

    }

}
