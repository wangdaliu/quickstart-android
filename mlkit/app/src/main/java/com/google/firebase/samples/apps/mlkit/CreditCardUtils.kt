package com.google.firebase.samples.apps.mlkit.com.google.firebase.samples.apps.mlkit

import com.google.firebase.samples.apps.mlkit.CreditCardChangedListener

object CreditCardUtils {

    private val numberRegex = Regex("^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})\$")

//    private val expiryRegex = Regex("(?:0[1-9]|1[0-2])/[0-9]{2}")

    fun matchCardInfo(listener: CreditCardChangedListener, result: String) {
        val word = result.replace("\n", "")

        if (word.replace(" ", "").matches(numberRegex)) {
            listener.onCardNumberChanged(word)
        }

        if (word.contains("/")) {
            val list = word.split(" ")
            for (separate in list) {
                if (separate.contains("/")) {
                    val numberString = separate.replace("\\D".toRegex(), "")
                    if (numberString.length == 4) {
                        listener.onCardExpiryChanged(numberString.substring(0, 2) + "/" + numberString.substring(2, 4))
                    }
                }
            }
        }
    }
}