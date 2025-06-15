package io.cheddarswallet.uniswapkit

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.core.IMethodDecorator
import io.cheddarswallet.uniswapkit.contract.SwapContractMethodFactories

class SwapMethodDecorator(private val contractMethodFactories: SwapContractMethodFactories) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
