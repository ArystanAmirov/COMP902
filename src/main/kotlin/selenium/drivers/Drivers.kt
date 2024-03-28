package selenium.drivers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

class Drivers {
    fun chromeDriver(): WebDriver {
        System.setProperty("webdriver.chrome.driver", "E:\\INSTALL\\IdeaProjects\\COMP902\\drivers\\chromedriver-win64\\chromedriver.exe")
        val driver: WebDriver = ChromeDriver()
        driver.manage().window().maximize()
        return driver
    }

    fun firefoxDriver(): WebDriver {
        System.setProperty("webdriver.gecko.driver", "E:\\INSTALL\\IdeaProjects\\COMP902\\drivers\\geckodriver.exe")
        val options = FirefoxOptions()
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe")
        val driver: WebDriver = FirefoxDriver(options)
        driver.manage().window().maximize()
        return driver
    }

    fun edgeDriver(): WebDriver {
        System.setProperty("webdriver.edge.driver", "E:\\INSTALL\\IdeaProjects\\COMP902\\drivers\\edgedriver_win64\\msedgedriver.exe")
        val driver: WebDriver = EdgeDriver()
        driver.manage().window().maximize()
        return driver
    }
}