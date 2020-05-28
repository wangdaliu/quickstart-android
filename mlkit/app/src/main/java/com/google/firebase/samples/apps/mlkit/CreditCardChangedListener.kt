package com.google.firebase.samples.apps.mlkit

interface CreditCardChangedListener {

    fun onCardNumberChanged(number: String)
    fun onCardExpiryChanged(expiry: String)
}