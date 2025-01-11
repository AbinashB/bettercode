package org.example.solid.openclose

// Class should be open for extension or add new feature but closed for changes
// here InterfaceValidateOtp isValid function open for extension to add new method of validation but closed for any modification

fun main() {
    val sendOtp =  OpenCloseFixedSendOpt()
    sendOtp.sendOpt("123456", validateEmail())
    sendOtp.sendOpt("abc123", validateAlexa())
}

class OpenCloseFixedSendOpt() {
    fun sendOpt(otp: String, interfaceValid: InterfaceValidateOtp) {
        if (interfaceValid.isValid(otp)) {
            println("Submitting OTP: $otp")
        }
    }
}

class validateEmail : InterfaceValidateOtp {
    override fun isValid(otp: String): Boolean{
        return otp.length == 6 && otp.all { it.isDigit() }
    }
}
class validatePhone : InterfaceValidateOtp {
    override fun isValid(otp: String): Boolean{
        return otp.length == 6 && otp.all { it.isDigit() } && otp.startsWith("123")
    }
}
class validateAlexa : InterfaceValidateOtp {
    override fun isValid(otp: String): Boolean{
        return otp.length == 6 && otp.all { it.isLetterOrDigit() }
    }
}

interface InterfaceValidateOtp {
   fun isValid(otp: String): Boolean
}
