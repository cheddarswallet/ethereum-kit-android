package io.cheddarswallet.uniswapkit.v3.router

import io.cheddarswallet.ethereumkit.contracts.ContractMethod
import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactories
import io.cheddarswallet.ethereumkit.contracts.ContractMethodFactory
import io.cheddarswallet.ethereumkit.contracts.ContractMethodHelper
import io.cheddarswallet.ethereumkit.core.hexStringToByteArray
import io.cheddarswallet.ethereumkit.core.toRawHexString
import org.web3j.abi.FunctionEncoder
import org.web3j.abi.TypeDecoder
import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.DynamicArray
import org.web3j.abi.datatypes.DynamicBytes
import org.web3j.abi.datatypes.Function

class MulticallMethod(val methods: List<ContractMethod>) : ContractMethod() {
    override val methodSignature = Companion.methodSignature

    override fun encodedABI(): ByteArray {
        val function = Function(
            "multicall",
            listOf(
                DynamicArray(methods.map { DynamicBytes(it.encodedABI()) })
            ),
            listOf()
        )

        return FunctionEncoder.encode(function).hexStringToByteArray()
    }

    companion object {
        private const val methodSignature = "multicall(bytes[])"
    }

    class Factory(private val factories: ContractMethodFactories) : ContractMethodFactory {
        override val methodId = ContractMethodHelper.getMethodId(methodSignature)

        override fun createMethod(inputArguments: ByteArray): MulticallMethod {
            val decode = TypeDecoder
                .decodeDynamicArray(
                    inputArguments.copyOfRange(32, inputArguments.size).toRawHexString(),
                    0,
                    object : TypeReference<DynamicArray<DynamicBytes>>() {

                    }
                )

            val methods = decode.value.mapNotNull {
                factories.createMethodFromInput(it.value)
            }

            return MulticallMethod(methods)
        }
    }
}
