package io.cheddarswallet.nftkit.contracts

import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories

object Eip1155ContractMethodFactories : ContractMethodFactories() {
    init {
        registerMethodFactories(listOf(Eip1155SafeTransferFromMethodFactory()))
    }
}
