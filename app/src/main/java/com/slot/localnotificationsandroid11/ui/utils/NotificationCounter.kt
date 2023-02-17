package com.slot.localnotificationsandroid11.ui.utils

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

object NotificationCounter {

     var id = 1
}

@OptIn(ExperimentalContracts::class)
inline fun <T1 : Any, T2 : Any, R : Any> multiLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
     contract {
          callsInPlace(block, InvocationKind.EXACTLY_ONCE)
     }
     return if (p1 != null && p2 != null) block(p1, p2) else null
}