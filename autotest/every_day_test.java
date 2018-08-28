package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class every_day_test {

    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void maintestfunction() throws InterruptedException{

        //пункт 1 - thefeedfeed к-ть постів
        driver.get("https://admin.thefeedfeed.com/login");
        WebElement login_field = driver.findElement(By.name("email"));
        login_field.sendKeys("marina.chepurna@gmail.com");
        WebElement password_field = driver.findElement(By.name("password"));
        password_field.sendKeys("marina.chepurna");
        WebElement enter_button = driver.findElement(By.xpath("//span[text()='Enter']"));
        enter_button.click();
        Thread.sleep(3000);
        WebElement post_quantity = driver.findElement(By.cssSelector("div[class^='inline-margin padding-10']"));
        String post_quantity_string = post_quantity.getText();
        String for_print = post_quantity_string.substring(16, post_quantity_string.length());


        // пункт 7-8 - instagram к-ть постів за хештегами
        driver.get("https://www.instagram.com/explore/tags/thefeedfeed/");
        Thread.sleep(3000);
        WebElement the_tag_quantity = driver.findElement(By.cssSelector("span.g47SY"));
        String the_tag_quantity_string = the_tag_quantity.getText();

        driver.get("https://www.instagram.com/explore/tags/feedfeed/");
        Thread.sleep(3000);
        WebElement tag_quantity = driver.findElement(By.cssSelector("span.g47SY"));
        String tag_quantity_string = tag_quantity.getText();



        // пункт 4 - download time
        Thread.sleep(3000);
        Date start_download = new Date();
        long start_time = start_download.getTime();
        driver.get("https://thefeedfeed.com/");
        Date end_download = new Date();
        long end_time = end_download.getTime();
        long download_time = end_time - start_time;



        //show result
        System.out.println("1.post on site:" + for_print);
        System.out.println("2.feed: TEST IT YOUSELF");
        System.out.println("3.partner: TEST IT YOUSELF");
        System.out.println("4.homepage download time:  " + download_time/1000 + "." + download_time%1000 + " seconds, XXX second with cash" );
        System.out.println("7.post with #thefeedfeed in Instagram: " + the_tag_quantity_string);
        System.out.println("8.post with #feedfeed in Instagram: " + tag_quantity_string);
        System.out.println("9.post schedules: TEST IT YOUSELF");


    }

    @AfterClass
    public static void endfunction()
    {



    }

}
