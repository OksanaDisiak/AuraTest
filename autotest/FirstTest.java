package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://twitter.com/login");

    }

    @Test
    public void userLogin() throws InterruptedException {
        System.out.println("test start");

        WebElement loginField = driver.findElement(By.className("js-username-field"));
        loginField.sendKeys("xxxx");
        WebElement passwordField = driver.findElement(By.className("js-password-field"));
        passwordField.sendKeys("xxxx");
        WebElement loginButton = driver.findElement(By.className("EdgeButtom--medium"));
        loginButton.click();

        WebElement newTweetText = driver.findElement(By.className("is-showPlaceholder"));
        loginButton.click();


    //    System.out.println("Log in");

      //  Thread.sleep(4000);
    //    WebElement profileUser = driver.findElement(By.cssSelector(".ProfileHeaderCard-name"));
     //   String mailUser = profileUser.getText();
        //Assert.assertEquals("design2pro", mailUser);
    }

    @AfterClass
    public static  void tearDown() throws InterruptedException {
        WebElement menuUser = driver.findElement(By.className("js-dropdown-toggle"));
        menuUser.click();

    Thread.sleep(4000);

    WebElement logoutButton = driver.findElement(By.className("js-signout-button"));
        logoutButton.click();
    //    driver.quit();
    }

}
