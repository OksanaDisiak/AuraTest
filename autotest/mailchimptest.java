package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ua.org.autotest.UserSubscribe;

import java.nio.channels.Selector;
import java.util.concurrent.TimeUnit;

public class mailchimptest {

    public static WebDriver driver;

    @BeforeClass
    public static void before(){
        System.out.println("TEST BEGIN");
        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void mailchimp_test() throws InterruptedException{
        int k = 0;
        driver.get("https://thefeedfeed.com/");

        WebElement subscribe_button;
        WebElement email_field;
        WebElement firstname_field;
        WebElement lastname_field;
        WebElement insta_field;
        WebElement cookinglevel_field;
        WebElement city_field;
        WebElement country_field;
        WebElement flag_1;
        WebElement flag_2;
        WebElement flag_3;
        WebElement flag_4;
        WebElement flag_5;
        WebElement flag_6;
        WebElement flag_7;
        WebElement flag_8;
        WebElement join_button;

        while(k!=3){

            UserSubscribe userSubscribe = new UserSubscribe();

            subscribe_button = driver.findElement(By.className("subscribe-button"));
            subscribe_button.click();

            Thread.sleep(3000);
            email_field = driver.findElement(By.id("EMAIL"));
            email_field.sendKeys(userSubscribe.email);

            firstname_field = driver.findElement(By.name("first_name"));
            firstname_field.sendKeys(userSubscribe.first_name);

            lastname_field = driver.findElement(By.name("last_name"));
            lastname_field.sendKeys(userSubscribe.last_name);

            insta_field = driver.findElement(By.name("username"));
            insta_field.sendKeys(userSubscribe.insta);

            cookinglevel_field = driver.findElement(By.className("Select-placeholder"));
        //    Select select = new Select(cookinglevel_field);
        //    cookinglevel_field.click();
        /*    switch(userSubscribe.cook_level) {
                case 0: select.selectByVisibleText("I DON`T KNOW");break;
                case 1: select.selectByVisibleText("Beginner");break;
                case 2: select.selectByVisibleText("Intermediate");break;
                case 3: select.selectByVisibleText("Advanced");break;
                case 0: cookinglevel_field.sendKeys("I DON`T KNOW");break;
                case 1: cookinglevel_field.sendKeys("Beginner");break;
                case 2: cookinglevel_field.sendKeys("Intermediate");break;
                case 3: cookinglevel_field.sendKeys("Advanced");break;
                default: break;
            }*/



            city_field = driver.findElement(By.name("city"));
            city_field.sendKeys(userSubscribe.city);

            country_field = driver.findElement(By.name("country"));
            country_field.sendKeys(userSubscribe.country);

           // flag_1
           // flag_1
           // flag_1
           // flag_1
           // flag_1
           // flag_1
           // flag_1
           // flag_1

            join_button = driver.findElement(By.xpath("//button[text()='Join us']"));
            join_button.click();

            Thread.sleep(3000);


            k++;
        }


    }

    @AfterClass
    public static void after(){
    System.out.println("TEST END");
    }
}
