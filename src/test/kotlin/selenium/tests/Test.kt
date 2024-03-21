package selenium.tests

import ms_playwright.configs.TestListener
import ms_playwright.configs.URL
import selenium.pages.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.annotations.Listeners
import org.testng.annotations.Test
import selenium.drivers.Drivers
import selenium.lists.User
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Listeners(TestListener::class)
class Test(private val user: User = selenium.lists.user) {

    private val driver: WebDriver = Drivers().chromeDriver()

    @Test(priority = 1)
    fun register() {
        driver.get(URL)
        driver.findElement(By.xpath(mainPage.register_btn)).click()
        driver.findElement(By.xpath(registerPage.fullName_input)).sendKeys(user.fullName)
        driver.findElement(By.xpath(registerPage.userName_input)).sendKeys(user.userName)
        driver.findElement(By.xpath(registerPage.email_input)).sendKeys(user.email)
        driver.findElement(By.xpath(registerPage.password_input)).sendKeys(user.password)
        driver.findElement(By.xpath(registerPage.passwordConfirmation_input)).sendKeys(user.passwordConfirmation)
        driver.findElement(By.xpath(registerPage.signUp_btn)).click()
        assertTrue(driver.findElement(By.xpath(mainPage.successRegistration_label)).isDisplayed)
    }

    @Test(priority = 2)
    fun login() {
        driver.findElement(By.xpath(loginPage.login_btn)).click()
        driver.findElement(By.xpath(loginPage.userName_input)).sendKeys(user.userName)
        driver.findElement(By.xpath(loginPage.password_input)).sendKeys(user.password)
        driver.findElement(By.xpath(loginPage._login_btn)).click()
        assertEquals(driver.findElement(By.xpath(mainPage.username_label)).text, user.userName)
    }

    @Test(priority = 3)
    fun addItemsToCart() {
        for (i in 1..10) {
            driver.findElement(By.xpath(mainPage.addToCart_btn.replace("index", "$i"))).click()
            driver.findElement(By.xpath(cartPage.addMoreItems_btn)).click()
        }
        driver.findElement(By.xpath(mainPage.cartIcon_btn)).click()
        driver.findElement(By.xpath(cartPage.completeOrder)).click()
        driver.findElement(By.xpath(cartPage.ok_btn)).click()
    }

    @Test(priority = 4)
    fun checkOrders() {
        driver.findElement(By.xpath(mainPage.orders_btn)).click()
        assertEquals(10, driver.findElements(By.xpath(ordersPage.itemsTable)).size)
    }

    @Test(priority = 5)
    fun logout() {
        driver.findElement(By.xpath(ordersPage.logout_btn)).click()
        assertTrue(driver.findElement(By.xpath(mainPage.register_btn)).isDisplayed)
        assertTrue(driver.findElement(By.xpath(mainPage.login_btn)).isDisplayed)
        driver.quit()
    }
}
