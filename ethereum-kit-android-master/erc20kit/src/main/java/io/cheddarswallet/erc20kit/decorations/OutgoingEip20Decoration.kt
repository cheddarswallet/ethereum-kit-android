package io.cheddarswallet.erc20kit.decorations

import io.cheddarswallet.erc20kit.events.TokenInfo
import io.cheddarswallet.ethereumkit.decorations.TransactionDecoration
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionTag
import java.math.BigInteger

class OutgoingEip20Decoration(
    val contractAddress: Address,
    val to: Address,
    val value: BigInteger,
    val sentToSelf: Boolean,
    val tokenInfo: TokenInfo?
) : TransactionDecoration {

    override fun tags() = listOf(
        contractAddress.hex,
        TransactionTag.EIP20_TRANSFER,
        TransactionTag.tokenOutgoing(contractAddress.hex),
        TransactionTag.OUTGOING,
        TransactionTag.toAddress(to.hex)
    )

}
