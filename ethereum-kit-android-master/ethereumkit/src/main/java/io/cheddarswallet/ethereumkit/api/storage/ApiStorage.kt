package io.cheddarswallet.ethereumkit.api.storage

import io.cheddarswallet.ethereumkit.api.models.AccountState
import io.cheddarswallet.ethereumkit.api.models.LastBlockHeight
import io.cheddarswallet.ethereumkit.core.IApiStorage

class ApiStorage(
        private val database: ApiDatabase
) : IApiStorage {

    override fun getLastBlockHeight(): Long? {
        return database.lastBlockHeightDao().getLastBlockHeight()?.height
    }

    override fun saveLastBlockHeight(lastBlockHeight: Long) {
        database.lastBlockHeightDao().insert(LastBlockHeight(lastBlockHeight))
    }

    override fun saveAccountState(state: AccountState) {
        database.balanceDao().insert(state)
    }

    override fun getAccountState(): AccountState? {
        return database.balanceDao().getAccountState()
    }

}
