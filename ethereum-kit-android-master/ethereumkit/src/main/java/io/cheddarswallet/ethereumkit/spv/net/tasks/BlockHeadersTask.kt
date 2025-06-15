package io.cheddarswallet.ethereumkit.spv.net.tasks

import io.cheddarswallet.ethereumkit.spv.core.ITask
import io.cheddarswallet.ethereumkit.spv.models.BlockHeader

class BlockHeadersTask(val blockHeader: BlockHeader, val limit: Int, val reverse: Boolean = false) : ITask
