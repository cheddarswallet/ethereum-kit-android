package io.cheddarswallet.uniswapkit.v3.quoter

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.uniswapkit.v3.SwapPath
import java.math.BigInteger

class QuoteExactInputMethod(
    val path: SwapPath,
    val amountIn: BigInteger,
) : ContractMethod() {

    override val methodSignature = "quoteExactInput(bytes,uint256)"
    override fun getArguments() = listOf(path.abiEncodePacked(), amountIn)

}
