package io.cheddarswallet.uniswapkit.v3.router

import io.cheddarswallet.ethereumkit.contracts.ContractMethod

class RefundETHMethod : ContractMethod() {
    override val methodSignature = "refundETH()"
}

