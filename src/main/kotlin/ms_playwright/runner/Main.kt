package ms_playwright.runner

import org.testng.TestNG
import ms_playwright.tests.PlaywrightTest
import selenium.tests.SeleniumTest

fun main(args: Array<String>) {
    val testng = TestNG()
    testng.setTestClasses(arrayOf(PlaywrightTest::class.java))
    testng.run()
}

//fun main(args: Array<String>) {
//    val testng = TestNG()
//    testng.setTestClasses(arrayOf(SeleniumTest::class.java))
//    testng.run()
//}
