package tests

import configs.*
import lists.*
import pages.*
import org.testng.annotations.Test
import java.lang.Thread.sleep


class Test (private val user: User = lists.user) {
    @Test(priority = 1)
    fun register() {
        user.page.navigate(URL)
        user.page.click(mainPage.register_btn)
        user.page.fill(registerPage.fullName_input, user.fullName)
        user.page.fill(registerPage.userName_input, user.userName)
        user.page.fill(registerPage.email_input, user.email)
        user.page.fill(registerPage.password_input, user.password)
        user.page.fill(registerPage.passwordConfirmation_input, user.passwordConfirmation)
        user.page.click(registerPage.signUp_btn)

    }

    @Test(priority = 2)
    fun login() {
        user.page.navigate(URL)
        user.page.click(loginPage.login_btn)
        user.page.fill(loginPage.userName_input, user.userName)
        user.page.fill(loginPage.password_input, user.password)
        user.page.click(loginPage._login_btn)
        sleep(5000)
    }
}
