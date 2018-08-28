package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test_all_video {

    public static WebDriver driver;

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.HOURS);
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://thefeedfeed.com/videos");

        System.out.println("opened video page");
        System.out.println("Skrolling");

        for(int s = 0; s < 50; s++){
            (  (JavascriptExecutor)driver).executeScript("window.scrollBy(0,700)", "");
            Thread.sleep(700);
        }

        System.out.println("Initialized");
        List<WebElement> video =  driver.findElements(By.cssSelector("a.img-block"));
        List<WebElement> video_title =  driver.findElements(By.cssSelector("div.video-title"));
        List<String> ref = new ArrayList<String>();
        List<String> title = new ArrayList<String>();

        System.out.println("Get ref");
        for(int i = 0; i < video.size(); i++){
            ref.add(video.get(i).getAttribute("href"));
            title.add(video_title.get(i).getText());
            System.out.println( i + "." + title.get(i) + ":  " + ref.get(i));
        }

        WebElement h1;
        String page_title;

        System.out.println("Open and check ind page");
        for(int k = 0; k < video.size(); k++){
            driver.get(ref.get(k));
            Thread.sleep(3000);

            h1 = driver.findElement(By.tagName("h1"));
            page_title = h1.getText();

            String page_title_low = page_title.toLowerCase();
            String title_low = title.get(k).toLowerCase();

            if(!title_low.startsWith(page_title_low)){
                System.out.println( k + "." + title.get(k) + ":  " + ref.get(k) + " - REDIRECT");
            }
            else System.out.println( k + "." + title.get(k) + ":  " + ref.get(k) + " - ALL IS RIGHT");

            Thread.sleep(1000);

        }
    }

    @AfterClass
    public static void endtest(){
        System.out.println("END TEST");
    }

}
