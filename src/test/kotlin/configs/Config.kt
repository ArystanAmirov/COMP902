package configs


import com.microsoft.playwright.*

//const val URL = "https://mywebapp29.azurewebsites.net/"
const val URL = "https://localhost:7777/"


val playWrite: Playwright = Playwright.create()
var browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100.0).setTimeout(50000.0))
//var browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setTimeout(50000.0))
val browserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(1650, 1080))
val browserPage: Page = browserContext.newPage()
val testTimeout = browserContext.setDefaultTimeout(10000.0)


