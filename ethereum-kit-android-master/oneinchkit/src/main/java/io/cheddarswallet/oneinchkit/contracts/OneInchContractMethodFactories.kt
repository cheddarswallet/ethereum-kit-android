package io.cheddarswallet.oneinchkit.contracts

import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories
import io.cheddarswallet.oneinchkit.contracts.v4.SwapMethodFactoryV4
import io.cheddarswallet.oneinchkit.contracts.v4.UnoswapMethodFactoryV4
import io.cheddarswallet.oneinchkit.contracts.v4.UnparsedSwapMethodsFactoryV4
import io.cheddarswallet.oneinchkit.contracts.v5.SwapMethodFactoryV5
import io.cheddarswallet.oneinchkit.contracts.v5.UnoswapMethodFactoryV5
import io.cheddarswallet.oneinchkit.contracts.v5.UnparsedSwapMethodsFactoryV5

object OneInchContractMethodFactories : ContractMethodFactories() {

    init {
        val swapContractMethodFactories = listOf(
            UnoswapMethodFactoryV5(),
            SwapMethodFactoryV5(),
            UnparsedSwapMethodsFactoryV5(),
            UnoswapMethodFactoryV4(),
            SwapMethodFactoryV4(),
            UnparsedSwapMethodsFactoryV4()
        )
        registerMethodFactories(swapContractMethodFactories)
    }

}
