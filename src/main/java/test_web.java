import com.google.common.annotations.VisibleForTesting;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ConfirmationPage;
import pages.FormPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class test_web {

        public static void main(String[] args) throws InterruptedException {
            // Set the property for webdriver.chrome.driver to be the location to your local              download of chromedriver
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

            // Create new instance of ChromeDriver
            WebDriver driver = new ChromeDriver();

            // And now use this to visit Google
            driver.get("https://formy-project.herokuapp.com/form");
            FormPage formPage = new FormPage();
            formPage.submitForm(driver);

            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
            ConfirmationPage confirmationPage = new ConfirmationPage();
            confirmationPage.waitForAlertBanner(driver);
            Assertions.assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));

            Thread.sleep(2000);



            driver.quit();

        }



    }

