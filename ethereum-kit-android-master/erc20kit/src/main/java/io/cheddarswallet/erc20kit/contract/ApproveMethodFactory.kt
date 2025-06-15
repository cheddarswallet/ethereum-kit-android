package io.cheddarswallet.erc20kit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactory
import io.cheddarswallet.ethereumkit.contracts.ContractMethodHelper
import io.cheddarswallet.ethereumkit.models.Address
import io.cheddarswallet.ethereumkit.spv.core.toBigInteger

object ApproveMethodFactory : ContractMethodFactory {

    override val methodId = ContractMethodHelper.getMethodId(ApproveMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): ApproveMethod {
        val address = Address(inputArguments.copyOfRange(12, 32))
        val value = inputArguments.copyOfRange(32, 64).toBigInteger()

        return ApproveMethod(address, value)
    }

}
