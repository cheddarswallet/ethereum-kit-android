package io.cheddarswallet.ethereumkit.core.eip1559

import io.cheddarswallet.ethereumkit.core.EthereumKit
import io.cheddarswallet.ethereumkit.models.DefaultBlockParameter
import io.reactivex.Flowable
import io.reactivex.Single

class Eip1559GasPriceProvider(
        private val evmKit: EthereumKit
) {
    fun feeHistory(
            blocksCount: Long,
            rewardPercentile: List<Int>,
            defaultBlockParameter: DefaultBlockParameter = DefaultBlockParameter.Latest
    ): Flowable<FeeHistory> {
        return evmKit.lastBlockHeightFlowable
                .flatMapSingle {
                    feeHistorySingle(blocksCount, defaultBlockParameter, rewardPercentile)
                }
    }

    fun feeHistorySingle(blocksCount: Long, defaultBlockParameter: DefaultBlockParameter, rewardPercentile: List<Int>): Single<FeeHistory> {
        val feeHistoryRequest = FeeHistoryJsonRpc(
                blocksCount,
                defaultBlockParameter,
                rewardPercentile
        )
        return evmKit.rpcSingle(feeHistoryRequest)
    }
}
