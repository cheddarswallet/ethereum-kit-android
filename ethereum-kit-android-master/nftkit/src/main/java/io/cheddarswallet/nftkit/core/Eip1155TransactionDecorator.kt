package io.cheddarswallet.nftkit.core

import io.cheddarswallet.ethereumkit.contracts.ContractEventInstance
import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.core.ITransactionDecorator
import io.cheddarswallet.ethereumkit.decorations.TransactionDecoration
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.InternalTransaction
import io.cheddarswallet.nftkit.contracts.Eip1155SafeTransferFromMethod
import io.cheddarswallet.nftkit.decorations.OutgoingEip1155Decoration
import io.cheddarswallet.nftkit.events.Eip1155TransferEventInstance
import java.math.BigInteger

class Eip1155TransactionDecorator(
    private val userAddress: Address
) : ITransactionDecorator {

    override fun decoration(
        from: Address?,
        to: Address?,
        value: BigInteger?,
        contractMethod: ContractMethod?,
        internalTransactions: List<InternalTransaction>,
        eventInstances: List<ContractEventInstance>
    ): TransactionDecoration? {
        if (from == null || to == null || value == null || contractMethod == null) return null

        return when {
            contractMethod is Eip1155SafeTransferFromMethod && from == userAddress -> {
                OutgoingEip1155Decoration(
                    contractAddress = to,
                    to = contractMethod.to,
                    tokenId = contractMethod.tokenId,
                    value = contractMethod.value,
                    sentToSelf = contractMethod.to == userAddress,
                    tokenInfo = eventInstances.mapNotNull { it as? Eip1155TransferEventInstance }.firstOrNull { it.contractAddress == to }?.tokenInfo
                )
            }
            else -> null
        }
    }
}
