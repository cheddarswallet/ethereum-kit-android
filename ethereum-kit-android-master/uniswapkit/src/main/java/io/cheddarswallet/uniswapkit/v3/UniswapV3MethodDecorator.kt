package io.cheddarswallet.uniswapkit.v3

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.core.IMethodDecorator
import io.cheddarswallet.uniswapkit.v3.contract.UniswapV3ContractMethodFactories

class UniswapV3MethodDecorator(private val contractMethodFactories: UniswapV3ContractMethodFactories) :
    IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
