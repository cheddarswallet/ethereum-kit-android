package io.cheddarswallet.ethereumkit.decorations

import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionTag
import java.math.BigInteger

class IncomingDecoration(
    val from: Address,
    val value: BigInteger
) : TransactionDecoration {

    override fun tags() = listOf(
        TransactionTag.EVM_COIN,
        TransactionTag.EVM_COIN_INCOMING,
        TransactionTag.INCOMING,
        TransactionTag.fromAddress(from.hex)
    )

}
