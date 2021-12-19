package com.example.dreambuilders.model

data class PaymentRequest(

    var id: String? = null,
    var paymentmode: String? = null,
    var date: String? = null,
    var amount: String? = null,
    var email: String? = null,
    var invoiceno: String? = null,
    var inputdate: String? = null,
    var approved:String?=null,
    var oldbal:String?=null,
    var newbal:String?=null
)