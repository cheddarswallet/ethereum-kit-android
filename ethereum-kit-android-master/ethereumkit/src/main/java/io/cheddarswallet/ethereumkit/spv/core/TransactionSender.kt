package io.cheddarswallet.ethereumkit.spv.core

import io.cheddarswallet.ethereumkit.core.TransactionBuilder
import io.cheddarswallet.ethereumkit.models.Transaction
import io.cheddarswallet.ethereumkit.models.RawTransaction
import io.cheddarswallet.ethereumkit.models.Signature
import io.cheddarswallet.ethereumkit.spv.net.handlers.SendTransactionTaskHandler
import io.cheddarswallet.ethereumkit.spv.net.tasks.SendTransactionTask

class TransactionSender(
        private val transactionBuilder: TransactionBuilder,
) : SendTransactionTaskHandler.Listener {

    interface Listener {
        fun onSendSuccess(sendId: Int, transaction: Transaction)
        fun onSendFailure(sendId: Int, error: Throwable)
    }

    var listener: Listener? = null

    fun send(sendId: Int, taskPerformer: ITaskPerformer, rawTransaction: RawTransaction, signature: Signature) {
        taskPerformer.add(SendTransactionTask(sendId, rawTransaction, signature))
    }

    override fun onSendSuccess(task: SendTransactionTask) {
        val transaction = transactionBuilder.transaction(task.rawTransaction, task.signature)

        listener?.onSendSuccess(task.sendId, transaction)
    }

    override fun onSendFailure(task: SendTransactionTask, error: Throwable) {
        listener?.onSendFailure(task.sendId, error)
    }

}
