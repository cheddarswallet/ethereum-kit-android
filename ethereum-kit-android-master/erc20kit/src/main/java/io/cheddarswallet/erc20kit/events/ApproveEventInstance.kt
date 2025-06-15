package io.cheddarswallet.erc20kit.events

import io.cheddarswallet.ethereumkit.contracts.ContractEventInstance
import io.cheddarswallet.ethereumkit.models.Address
import java.math.BigInteger

class ApproveEventInstance(
    contractAddress: Address,
    val owner: Address,
    val spender: Address,
    val value: BigInteger
) : ContractEventInstance(contractAddress)
