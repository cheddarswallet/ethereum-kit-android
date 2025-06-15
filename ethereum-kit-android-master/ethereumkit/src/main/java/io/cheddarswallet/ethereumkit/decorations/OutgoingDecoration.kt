package io.cheddarswallet.ethereumkit.decorations

import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionTag
import java.math.BigInteger

class OutgoingDecoration(
    val to: Address,
    val value: BigInteger,
    val sentToSelf: Boolean
) : TransactionDecoration {

    override fun tags() = buildList {
        addAll(listOf(TransactionTag.EVM_COIN, TransactionTag.EVM_COIN_OUTGOING, TransactionTag.OUTGOING))

        if (sentToSelf) {
            addAll(listOf(TransactionTag.EVM_COIN_INCOMING, TransactionTag.INCOMING))
        }

        add(TransactionTag.toAddress(to.hex))
    }

}
