package io.cheddarswallet.ethereumkit.spv.net.devp2p.messages

import io.cheddarswallet.ethereumkit.core.hexStringToByteArray
import io.cheddarswallet.ethereumkit.spv.net.IInMessage

class PingMessage() : IInMessage {

    constructor(payload: ByteArray) : this()

    override fun toString(): String {
        return "Ping"
    }

    companion object {
        val payload = "C0".hexStringToByteArray()
    }
}
