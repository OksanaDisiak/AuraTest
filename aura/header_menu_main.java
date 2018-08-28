package header_menu.feedfeed.aura;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import header_menu.feedfeed.aura.social_network_inheader;

public class header_menu_main {



    public static WebDriver driver;

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.HOURS);

    }

    @Test
    public void homepage_test() throws InterruptedException {  // don`t contain test for TV, ABOUT      SUBSCRIBE, SEARCH, LOG IN/OUT - apart

        social_network_inheader social_network_test = new social_network_inheader();
        social_network_test.social_network_inheader_test();



    }

    @AfterClass
    public static void endtest(){
        System.out.println("TEST END");

    }

}
