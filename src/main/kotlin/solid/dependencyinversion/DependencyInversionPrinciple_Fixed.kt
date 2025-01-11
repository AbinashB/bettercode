package org.example.solid.dependencyinversion

// High level module should not depend upon low level module, both should depend upon abstraction
// Abstraction shouldn't depend upon details, Details should depend upon abstraction

fun main() {
    val paymentProcess1 = PaymentProcessorFixed(PaypalPaymentFixed())
    paymentProcess1.processPayment(1000.00)
    val paymentProcess2 = PaymentProcessorFixed(StripePaymentFixed())
    paymentProcess2.processPayment(2000.00)
}

class PaymentProcessorFixed (val paymentMethod: Payment){ // here we have passed a concrete class instead of abstraction
    fun processPayment(amount: Double){
        paymentMethod.pay(amount)
    }
}

class PaypalPaymentFixed : Payment{
    override fun pay(amount: Double){
        println("Procession amount to paypal $amount")
    }
}

interface Payment{
    fun pay(amount: Double)
}

class StripePaymentFixed : Payment{
    override fun pay(amount: Double){
        println("Procession amount to stripe $amount")
    }
}