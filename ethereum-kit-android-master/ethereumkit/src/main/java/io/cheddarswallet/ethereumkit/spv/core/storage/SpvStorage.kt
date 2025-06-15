package io.cheddarswallet.ethereumkit.spv.core.storage

import io.cheddarswallet.ethereumkit.core.ISpvStorage
import io.cheddarswallet.ethereumkit.spv.models.AccountStateSpv
import io.cheddarswallet.ethereumkit.spv.models.BlockHeader

class SpvStorage(private val database: SpvDatabase) : ISpvStorage {

    override fun getLastBlockHeader(): BlockHeader? {
        return database.blockHeaderDao().getAll().firstOrNull()
    }

    override fun saveBlockHeaders(blockHeaders: List<BlockHeader>) {
        return database.blockHeaderDao().insertAll(blockHeaders)
    }

    override fun getBlockHeadersReversed(fromBlockHeight: Long, limit: Int): List<BlockHeader> {
        return database.blockHeaderDao().getByBlockHeightRange(fromBlockHeight - limit, fromBlockHeight)
    }

    override fun getAccountState(): AccountStateSpv? {
        return database.accountStateDao().getAccountState()
    }

    override fun saveAccountSate(accountState: AccountStateSpv) {
        database.accountStateDao().insert(accountState)
    }

}
