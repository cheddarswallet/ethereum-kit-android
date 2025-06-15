package io.cheddarswallet.uniswapkit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories

object SwapContractMethodFactories : ContractMethodFactories() {
    init {
        val swapContractMethodFactories = listOf(
                SwapETHForExactTokensMethodFactory,
                SwapExactETHForTokensMethodFactory,
                SwapExactETHForTokensSupportingFeeOnTransferTokensMethodFactory,
                SwapExactTokensForETHMethodFactory,
                SwapExactTokensForETHSupportingFeeOnTransferTokensMethodFactory,
                SwapExactTokensForTokensMethodFactory,
                SwapExactTokensForTokensSupportingFeeOnTransferTokensMethodFactory,
                SwapTokensForExactETHMethodFactory,
                SwapTokensForExactTokensMethodFactory
        )
        registerMethodFactories(swapContractMethodFactories)
    }
}
