package io.cheddarswallet.uniswapkit.v3.quoter

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.uniswapkit.v3.SwapPath
import java.math.BigInteger

class QuoteExactOutputMethod(
    val path: SwapPath,
    val amountOut: BigInteger,
) : ContractMethod() {

    override val methodSignature = "quoteExactOutput(bytes,uint256)"
    override fun getArguments() = listOf(path.abiEncodePacked(), amountOut)

}
