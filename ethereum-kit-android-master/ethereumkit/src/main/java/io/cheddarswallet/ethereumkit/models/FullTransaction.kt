package io.cheddarswallet.ethereumkit.models

import io.cheddarswallet.ethereumkit.decorations.TransactionDecoration

class FullTransaction(
    val transaction: Transaction,
    val decoration: TransactionDecoration
)
