package io.cheddarswallet.ethereumkit.api.storage

import androidx.room.*
import io.cheddarswallet.ethereumkit.api.models.AccountState

@Dao
interface AccountStateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(accountState: AccountState)

    @Query("SELECT * FROM AccountState LIMIT 1")
    fun getAccountState(): AccountState?

}
