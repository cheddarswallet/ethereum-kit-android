package io.cheddarswallet.erc20kit.core

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories
import io.cheddarswallet.ethereumkit.core.IMethodDecorator

class Eip20MethodDecorator(
    private val contractMethodFactories: ContractMethodFactories
) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
