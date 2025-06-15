package io.cheddarswallet.ethereumkit.spv.net.tasks

import io.cheddarswallet.ethereumkit.spv.core.ITask
import io.cheddarswallet.ethereumkit.models.RawTransaction
import io.cheddarswallet.ethereumkit.models.Signature

class SendTransactionTask(val sendId: Int,
                          val rawTransaction: RawTransaction,
                          val signature: Signature) : ITask
