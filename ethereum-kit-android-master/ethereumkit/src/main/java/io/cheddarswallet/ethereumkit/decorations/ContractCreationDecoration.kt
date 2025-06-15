package io.cheddarswallet.ethereumkit.decorations

class ContractCreationDecoration : TransactionDecoration {
    override fun tags() = listOf("contractCreation")
}
