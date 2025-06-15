package io.cheddarswallet.ethereumkit.contracts

import io.cheddarswallet.ethereumkit.models.Address

open class ContractEventInstance(val contractAddress: Address) {

    open fun tags(userAddress: Address): List<String> = listOf()

}
