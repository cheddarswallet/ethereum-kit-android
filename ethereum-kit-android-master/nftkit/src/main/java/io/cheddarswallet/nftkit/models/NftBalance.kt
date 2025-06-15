package io.cheddarswallet.nftkit.models

import androidx.room.Embedded

data class NftBalance(
    @Embedded
    val nft: Nft,
    val balance: Int,
    val synced: Boolean
)
