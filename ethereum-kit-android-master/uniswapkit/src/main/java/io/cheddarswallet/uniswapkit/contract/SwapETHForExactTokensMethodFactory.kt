package io.cheddarswallet.uniswapkit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactory
import io.cheddarswallet.ethereumkit.contracts.ContractMethodHelper
import io.cheddarswallet.ethereumkit.models.Address
import java.math.BigInteger

object SwapETHForExactTokensMethodFactory : ContractMethodFactory {

    override val methodId = ContractMethodHelper.getMethodId(SwapETHForExactTokensMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): ContractMethod {
        val parsedArguments = ContractMethodHelper.decodeABI(inputArguments, listOf(BigInteger::class, List::class, Address::class, BigInteger::class))
        val amountOut = parsedArguments[0] as BigInteger
        val path = parsedArguments[1] as List<Address>
        val to = parsedArguments[2] as Address
        val deadline = parsedArguments[3] as BigInteger
        return SwapETHForExactTokensMethod(amountOut, path, to, deadline)
    }

}
