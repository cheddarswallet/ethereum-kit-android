package io.cheddarswallet.nftkit.contracts

import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories

object Eip721ContractMethodFactories : ContractMethodFactories() {
    init {
        registerMethodFactories(listOf(Eip721SafeTransferFromMethodFactory()))
    }
}
