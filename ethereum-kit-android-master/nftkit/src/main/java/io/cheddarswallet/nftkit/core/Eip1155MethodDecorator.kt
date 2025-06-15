package io.cheddarswallet.nftkit.core

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories
import io.cheddarswallet.ethereumkit.core.IMethodDecorator

class Eip1155MethodDecorator(
    private val contractMethodFactories: ContractMethodFactories
) : IMethodDecorator {
    override fun contractMethod(input: ByteArray): ContractMethod? {
        return contractMethodFactories.createMethodFromInput(input)
    }
}
