package io.cheddarswallet.ethereumkit.api.storage

import androidx.room.*
import io.cheddarswallet.ethereumkit.api.models.LastBlockHeight

@Dao
interface LastBlockHeightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lastBlockHeight: LastBlockHeight)

    @Query("SELECT * FROM LastBlockHeight")
    fun getLastBlockHeight(): LastBlockHeight?

}
