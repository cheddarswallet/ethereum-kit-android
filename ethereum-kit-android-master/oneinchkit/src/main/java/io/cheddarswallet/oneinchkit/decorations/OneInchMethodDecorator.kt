package io.cheddarswallet.oneinchkit.decorations

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.core.IMethodDecorator
import io.cheddarswallet.oneinchkit.contracts.OneInchContractMethodFactories

class OneInchMethodDecorator(private val contractMethodFactories: OneInchContractMethodFactories) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
