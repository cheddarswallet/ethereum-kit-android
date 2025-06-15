package io.cheddarswallet.erc20kit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethod

class DecimalsMethod: ContractMethod() {
    override var methodSignature = "decimals()"
    override fun getArguments() = listOf<Any>()
}
