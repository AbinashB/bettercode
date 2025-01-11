package org.example.solid.dependencyinversion

// High level module should not depend upon low level module, both should depend upon abstraction
// Abstraction shouldn't depend upon details, Details should depend upon abstraction

fun main() {
    val paymentProcess = PaymentProcessor(PaypalPayment())
    paymentProcess.processPayment(1000.00)
}

class PaymentProcessor (val payment: PaypalPayment){ // here we have passed a concrete class instead of abstraction
    fun processPayment(amount: Double){
        payment.pay(amount)
    }
}

class PaypalPayment{
    fun pay(amount: Double){
        println("Procession amount $amount")
    }
}


class StripePayment{
    fun pay(amount: Double){
        println("Procession amount $amount")
    }
}