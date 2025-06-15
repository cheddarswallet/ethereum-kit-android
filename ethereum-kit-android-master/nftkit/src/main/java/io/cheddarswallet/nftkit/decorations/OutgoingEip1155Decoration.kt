package io.cheddarswallet.nftkit.decorations

import io.cheddarswallet.ethereumkit.decorations.TransactionDecoration
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionTag
import io.cheddarswallet.nftkit.models.TokenInfo
import java.math.BigInteger

class OutgoingEip1155Decoration(
    val contractAddress: Address,
    val to: Address,
    val tokenId: BigInteger,
    val value: BigInteger,
    val sentToSelf: Boolean,
    val tokenInfo: TokenInfo?,
) : TransactionDecoration {

    override fun tags() = listOf(
        contractAddress.hex,
        EIP1155_TRANSFER,
        TransactionTag.tokenOutgoing(contractAddress.hex),
        TransactionTag.OUTGOING,
        TransactionTag.toAddress(to.hex)
    )

    companion object {
        const val EIP1155_TRANSFER = "eip1155Transfer"
    }
}
