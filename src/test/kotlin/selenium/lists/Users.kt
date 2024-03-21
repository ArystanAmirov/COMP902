package selenium.lists

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class User (
    var fullName: String,
    var userName: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
) {
    init {
        val currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyHHmmss"))
        fullName += with(currentDateTime) {substring(0, 8) + "_" + substring(8, 10) + "_" + substring(10, 12) + "_" + substring(12, 14)}
        userName += with(currentDateTime) {substring(0, 8) + "_" + substring(8, 10) + "_" + substring(10, 12) + "_" + substring(12, 14)}
    }
}

val user = User(

    "User ",
    "User_",
    "user@mywebapp29.com.nz",
    "User12345*",
    "User12345*"
)
