package org.example.solid.singleresponsibility

// Single class should have single objective or task
// here SentOtp takes care of OTP sending & ValidateOtp takes care of validation

fun main() {
    val sendOtp = SendOpt(ValidateOtp())
    sendOtp.sendOpt("123456","phone")
}

class SendOpt(private val validateOtp: ValidateOtp) {
    fun sendOpt(otp: String, method: String) {
        if (validateOtp.isValid(otp,method)) {
            println("Submitting OTP: $otp")
        }
    }
}

open class ValidateOtp {
    fun isValid(otp: String, method: String): Boolean {
        return when (method) {
            "email" -> otp.length == 6 && otp.all { it.isDigit() }
            "phone" -> otp.length == 6 && otp.all { it.isDigit() } && otp.startsWith("123")
            else -> false
        }
    }
}
