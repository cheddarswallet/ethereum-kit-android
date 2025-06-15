package io.cheddarswallet.nftkit.core

import io.cheddarswallet.nftkit.models.Nft
import io.cheddarswallet.nftkit.models.NftType

interface ITransactionSyncerListener {
    fun didSync(nfts: List<Nft>, type: NftType)
}

interface IBalanceSyncManagerListener {
    fun didFinishSyncBalances()
}
