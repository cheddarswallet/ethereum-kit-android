package io.cheddarswallet.erc20kit.decorations

import io.cheddarswallet.ethereumkit.contracts.ContractEvent
import io.cheddarswallet.ethereumkit.decorations.TransactionDecoration
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionTag
import java.math.BigInteger

class ApproveEip20Decoration(
    val contractAddress: Address,
    val spender: Address,
    val value: BigInteger
) : TransactionDecoration {

    override fun tags() = listOf(contractAddress.hex, TransactionTag.EIP20_APPROVE)

    companion object {
        val signature = ContractEvent(
            "Approval",
            listOf(
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Uint256
            )
        ).signature
    }
}
