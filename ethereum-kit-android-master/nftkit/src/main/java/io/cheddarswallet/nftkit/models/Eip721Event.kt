package io.cheddarswallet.nftkit.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import io.cheddarswallet.ethereumkit.core.toHexString
import io.cheddarswallet.ethereumkit.models.Address
import java.math.BigInteger

@Entity
data class Eip721Event(
    val hash: ByteArray,
    val blockNumber: Long,
    val contractAddress: Address,
    val from: Address,
    val to: Address,
    val tokenId: BigInteger,
    val tokenName: String,
    val tokenSymbol: String,
    val tokenDecimal: Int,

    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {

    @delegate:Ignore
    val hashString: String by lazy {
        hash.toHexString()
    }

}
