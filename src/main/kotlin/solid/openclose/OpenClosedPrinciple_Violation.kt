package org.example.solid.openclose

// Class should be open for extension or add new feature but closed for changes/modification
// here ExtendedOpenCloseValidateOtp override the function isValid which changed the functionality

fun main() {
    val sendOtp =  OpenCloseSendOpt(ExtendedOpenCloseValidateOtp())
    sendOtp.sendOpt("123456","phone")
    sendOtp.sendOpt("abc123","alexa")
}

class OpenCloseSendOpt(private val validateOtp: OpenCloseValidateOtp) {
    fun sendOpt(otp: String, method: String) {
        if (validateOtp.isValid(otp,method)) {
            println("Submitting OTP: $otp")
        }
    }
}

 class ExtendedOpenCloseValidateOtp : OpenCloseValidateOtp() {
    override fun isValid(otp: String, method: String): Boolean {
        return when (method) {
            "alexa" -> otp.length == 6 && otp.all { it.isLetterOrDigit() } // Example filter for "alexa"
            else -> super.isValid(otp, method) // Call the parent class method for other cases
        }
    }
}

open class  OpenCloseValidateOtp {
    open fun isValid(otp: String, method: String): Boolean {
        return when (method) {
            "email" -> otp.length == 6 && otp.all { it.isDigit() }
            "phone" -> otp.length == 6 && otp.all { it.isDigit() } && otp.startsWith("123")
            else -> false
        }
    }
}
