package io.cheddarswallet.ethereumkit.spv.net

import io.cheddarswallet.ethereumkit.core.ISpvStorage
import io.cheddarswallet.ethereumkit.network.INetwork
import io.cheddarswallet.ethereumkit.spv.models.BlockHeader

class BlockHelper(val storage: ISpvStorage, val network: INetwork) {

    val lastBlockHeader: BlockHeader
        get() = storage.getLastBlockHeader() ?: network.checkpointBlock

}
