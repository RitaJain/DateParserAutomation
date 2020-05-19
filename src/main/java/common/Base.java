package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties ();
        FileInputStream fis = new FileInputStream (System.getProperty ("user.dir") + "/src/main/resources/data.properties");
        prop.load (fis);
        String browserName = prop.getProperty ("browser");
        //String browserName= System.getProperty ("browser");
        if (browserName.contains ("chrome")) {
            System.out.println (System.getProperty ("user.dir"));
            System.setProperty ("webdriver.chrome.driver", System.getProperty ("user.dir") + "/src/main/resources/Driver/chromedriver");

            ChromeOptions options = new ChromeOptions ();
            if (browserName.contains ("headless")) {
                options.addArguments ("headless");
                System.setProperty ("webdriver.chrome.silentOutput", "true");
            }
            driver = new ChromeDriver (options);
        }
            else if (browserName.equals ("firefox")) {
                System.setProperty ("webdriver.firefox.driver", System.getProperty ("user.dir") + "/src/main/resources/Driver/geckodriver");
                driver = new FirefoxDriver ();
            }
            driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
            return driver;
        }
    }

