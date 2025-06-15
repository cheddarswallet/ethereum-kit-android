package io.cheddarswallet.erc20kit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethod

class SymbolMethod: ContractMethod() {
    override var methodSignature = "symbol()"
    override fun getArguments() = listOf<Any>()
}
