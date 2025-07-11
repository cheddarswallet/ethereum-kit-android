package io.cheddarswallet.uniswapkit

import io.cheddarswallet.ethereumkit.models.Chain
import io.cheddarswallet.uniswapkit.models.Token

class PairSelector(
    private val tokenFactory: TokenFactory
) {
    fun tokenPairs(chain: Chain, tokenA: Token, tokenB: Token): List<Pair<Token, Token>> =
        if (tokenA.isEther || tokenB.isEther) {
            listOf(Pair(tokenA, tokenB))
        } else {
            val etherToken = tokenFactory.etherToken(chain)

            listOf(Pair(tokenA, tokenB), Pair(tokenA, etherToken), Pair(tokenB, etherToken))
        }
}
