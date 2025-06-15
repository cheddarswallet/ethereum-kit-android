package io.cheddarswallet.ethereumkit.spv.net.tasks

import io.cheddarswallet.ethereumkit.network.INetwork
import io.cheddarswallet.ethereumkit.spv.core.ITask
import io.cheddarswallet.ethereumkit.spv.models.BlockHeader
import java.math.BigInteger

class HandshakeTask(val peerId: String, network: INetwork, blockHeader: BlockHeader) : ITask {
    val networkId: Int = network.id
    val genesisHash: ByteArray = network.genesisBlockHash
    val headTotalDifficulty: BigInteger = blockHeader.totalDifficulty
    val headHash: ByteArray = blockHeader.hashHex
    val headHeight: Long = blockHeader.height
}
