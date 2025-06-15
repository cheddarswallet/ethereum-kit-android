package io.cheddarswallet.erc20kit.core

import io.cheddarswallet.erc20kit.decorations.ApproveEip20Decoration
import io.cheddarswallet.erc20kit.events.ApproveEventInstance
import io.cheddarswallet.erc20kit.events.TransferEventInstance
import io.cheddarswallet.ethereumkit.contracts.ContractEventInstance
import io.cheddarswallet.ethereumkit.core.hexStringToByteArrayOrNull
import io.cheddarswallet.ethereumkit.core.toRawHexString
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.TransactionLog
import java.math.BigInteger

fun TransactionLog.getErc20EventInstance(): ContractEventInstance? {
    return try {
        if (topics.size != 3) {
            return null
        }

        val signature = topics[0].hexStringToByteArrayOrNull()

        val firstParam = Address(topics[1])
        val secondParam = Address(topics[2])

        when {
            signature.contentEquals(TransferEventInstance.signature) ->
                TransferEventInstance(address, firstParam, secondParam, BigInteger(data.toRawHexString(), 16), null)
            signature.contentEquals(ApproveEip20Decoration.signature) ->
                ApproveEventInstance(address, firstParam, secondParam, BigInteger(data.toRawHexString(), 16))
            else ->
                null
        }
    } catch (error: Throwable) {
        error.printStackTrace()
        null
    }
}
