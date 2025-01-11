package org.example.solid.singleresponsibility

// Single class should have single objective or task
// Here is clear violation sendOtp class takes care of validating an OTP


fun main() {
    val sendOtp = SendOtp()
    sendOtp.sendOpt("123456","phone")
}

class SendOtp {
    fun sendOpt(otp: String, method: String) {
        if (validateOtp(otp, method)) {
            println("Submitting OTP: $otp")
        }
    }

    fun validateOtp(otp: String, method: String): Boolean {
        return when (method) {
            "email" -> otp.length == 6 && otp.all { it.isDigit() }
            "phone" -> otp.length == 6 && otp.all { it.isDigit() } && otp.startsWith("123")
             else -> false
        }
    }
}