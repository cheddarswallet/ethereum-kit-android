package io.cheddarswallet.ethereumkit.spv.net.tasks

import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.spv.core.ITask
import io.cheddarswallet.ethereumkit.spv.models.BlockHeader

class AccountStateTask(val address: Address, val blockHeader: BlockHeader) : ITask
