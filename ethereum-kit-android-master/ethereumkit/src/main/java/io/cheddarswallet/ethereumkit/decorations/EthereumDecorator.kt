package io.cheddarswallet.ethereumkit.decorations

import io.cheddarswallet.ethereumkit.contracts.ContractEventInstance
import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.contracts.EmptyMethod
import io.cheddarswallet.ethereumkit.core.ITransactionDecorator
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.models.InternalTransaction
import java.math.BigInteger

class EthereumDecorator(private val address: Address) : ITransactionDecorator {

    override fun decoration(from: Address?, to: Address?, value: BigInteger?, contractMethod: ContractMethod?, internalTransactions: List<InternalTransaction>, eventInstances: List<ContractEventInstance>): TransactionDecoration? {
        if (from == null || value == null) return null
        if (to == null) return ContractCreationDecoration()

        if (contractMethod != null && contractMethod is EmptyMethod) {
            if (from == address) {
                return OutgoingDecoration(to, value, to == address)
            }

            if (to == address) {
                return IncomingDecoration(from, value)
            }
        }

        return null
    }

}
