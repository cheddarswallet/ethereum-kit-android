package io.cheddarswallet.uniswapkit.contract

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.models.Address
import java.math.BigInteger

class SwapExactTokensForTokensMethod(
        val amountIn: BigInteger,
        val amountOutMin: BigInteger,
        val path: List<Address>,
        val to: Address,
        val deadline: BigInteger
) : ContractMethod() {

    override val methodSignature = Companion.methodSignature
    override fun getArguments() = listOf(amountIn, amountOutMin, path, to, deadline)

    companion object {
        const val methodSignature = "swapExactTokensForTokens(uint256,uint256,address[],address,uint256)"
    }

}
