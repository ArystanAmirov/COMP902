package tests

import configs.TestListener
import configs.URL
import lists.User
import org.testng.annotations.Listeners
import org.testng.annotations.Test
import pages.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@Listeners(TestListener::class)
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
        assertTrue(user.page.isVisible(mainPage.successRegistration_label))
    }

    @Test(priority = 2)
    fun login() {
        user.page.click(loginPage.login_btn)
        user.page.fill(loginPage.userName_input, user.userName)
        user.page.fill(loginPage.password_input, user.password)
        user.page.click(loginPage._login_btn)
        assertEquals(user.page.innerText(mainPage.username_label).trimStart(), user.userName)
    }

    @Test(priority = 3)
    fun addItemsToCart() {
        for (i in 1..10) {
            user.page.click(mainPage.addToCart_btn.replace("index", "$i"))
            user.page.click(cartPage.addMoreItems_btn)
        }
        user.page.click(mainPage.cartIcon_btn)
        user.page.click(cartPage.completeOrder)
        user.page.click(cartPage.ok_btn)
    }

    @Test(priority = 4)
    fun checkOrders() {
        user.page.click(mainPage.orders_btn)
        assertEquals(10, user.page.locator(ordersPage.itemsTable).count())
    }

    @Test(priority = 5)
    fun logout() {
        user.page.click(ordersPage.logout_btn)
        assertTrue(user.page.isVisible(mainPage.register_btn))
        assertTrue(user.page.isVisible(mainPage.login_btn))
    }
}

