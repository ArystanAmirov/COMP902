package lists


import com.microsoft.playwright.Page
import configs.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class User (
    var fullName: String,
    var userName: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
    var page: Page = browserPage,
) {
    init {
        val currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
        fullName += currentDateTime
        userName += currentDateTime
    }
}

val user = User(

    "User ",
    "User",
    "user@mywebapp29.com.nz",
    "User12345*",
    "User12345*"
)
