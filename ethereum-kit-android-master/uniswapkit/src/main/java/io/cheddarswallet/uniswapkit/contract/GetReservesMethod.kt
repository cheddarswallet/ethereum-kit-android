package io.cheddarswallet.uniswapkit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethod

class GetReservesMethod : ContractMethod() {

    override val methodSignature = "getReserves()"
    override fun getArguments() = listOf<Any>()

}
