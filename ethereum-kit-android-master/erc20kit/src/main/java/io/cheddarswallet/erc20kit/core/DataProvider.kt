package io.cheddarswallet.erc20kit.core

import io.cheddarswallet.erc20kit.contract.BalanceOfMethod
import io.cheddarswallet.ethereumkit.core.EthereumKit
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.spv.core.toBigInteger
import io.reactivex.Single
import java.math.BigInteger

class DataProvider(
        private val ethereumKit: EthereumKit
) : IDataProvider {

    override fun getBalance(contractAddress: Address, address: Address): Single<BigInteger> {
        return ethereumKit.call(contractAddress, BalanceOfMethod(address).encodedABI())
                .map { it.sliceArray(IntRange(0, 31)).toBigInteger() }
    }

}
