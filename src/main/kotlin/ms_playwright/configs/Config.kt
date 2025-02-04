package ms_playwright.configs


import com.microsoft.playwright.*

const val URL = "https://localhost:7777/"
//const val URL = "https://mywebapp29-europe.azurewebsites.net/"

val playWrite: Playwright = Playwright.create()
var browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(000.0).setTimeout(50000.0))
//var browser: Browser = playWrite.firefox().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(000.0).setTimeout(50000.0))
//var browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(000.0).setTimeout(50000.0))
val browserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(1650, 1080))
val browserPage: Page = browserContext.newPage()



