package io.cheddarswallet.ethereumkit.spv.core

import io.cheddarswallet.ethereumkit.core.ISpvStorage
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.spv.models.AccountStateSpv
import io.cheddarswallet.ethereumkit.spv.models.BlockHeader
import io.cheddarswallet.ethereumkit.spv.net.handlers.AccountStateTaskHandler
import io.cheddarswallet.ethereumkit.spv.net.tasks.AccountStateTask

class AccountStateSyncer(private val storage: ISpvStorage,
                         private val address: Address) : AccountStateTaskHandler.Listener {

    interface Listener {
        fun onUpdate(accountState: AccountStateSpv)
    }

    var listener: Listener? = null

    fun sync(taskPerformer: ITaskPerformer, blockHeader: BlockHeader) {
        taskPerformer.add(AccountStateTask(address, blockHeader))
    }

    override fun didReceive(accountState: AccountStateSpv, address: Address, blockHeader: BlockHeader) {
        storage.saveAccountSate(accountState)
        listener?.onUpdate(accountState)
    }

}
