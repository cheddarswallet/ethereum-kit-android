package io.cheddarswallet.nftkit.decorations

import io.cheddarswallet.ethereumkit.decorations.TransactionDecoration
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionTag
import io.cheddarswallet.nftkit.models.TokenInfo
import java.math.BigInteger

class OutgoingEip721Decoration(
    val contractAddress: Address,
    val to: Address,
    val tokenId: BigInteger,
    val sentToSelf: Boolean,
    val tokenInfo: TokenInfo?,
) : TransactionDecoration {

    override fun tags() = listOf(
        contractAddress.hex,
        EIP721_TRANSFER,
        TransactionTag.tokenOutgoing(contractAddress.hex),
        TransactionTag.OUTGOING,
        TransactionTag.toAddress(to.hex)
    )

    companion object {
        const val EIP721_TRANSFER = "eip721Transfer"
    }
}
