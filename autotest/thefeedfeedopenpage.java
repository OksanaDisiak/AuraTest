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

public class thefeedfeedopenpage {

private static WebDriver driver;

@BeforeClass
    public static void setup(){

    System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    };

@Test
    public void testopenpage() throws InterruptedException{

    WebElement title;
    String titletext;


    driver.get("https://thefeedfeed.com/");
    System.out.println("the FeedFeed opened");
    Thread.sleep(3000);

    driver.get("https://thefeedfeed.com/feeds");
    System.out.println("feeds opened");
    Thread.sleep(3000);
    title = driver.findElement(By.tagName("h1"));
    titletext = title.getText();
    Assert.assertEquals("All Feeds", titletext);


    driver.get("https://thefeedfeed.com/stories");
    System.out.println("stories opened");
    Thread.sleep(3000);
    title = driver.findElement(By.tagName("h1"));
    titletext = title.getText();
    Assert.assertEquals("All Stories", titletext);


    driver.get("https://thefeedfeed.com/videos");
    System.out.println("videos opened");
    Thread.sleep(3000);
    title = driver.findElement(By.tagName("h1"));
    titletext = title.getText();
    Assert.assertEquals("All Videos", titletext);


    driver.get("https://thefeedfeed.com/tv");
    System.out.println("TV opened");
    Thread.sleep(3000);
//    title = driver.findElement(By.cssSelector("h2 .tv-link-title"));
//    titletext = title.getText();
  //  Assert.assertEquals("FEATURED EPISODES > ALL", titletext);


    driver.get("https://thefeedfeed.com/conversations");
    System.out.println("conversations opened");
    Thread.sleep(3000);
    title = driver.findElement(By.tagName("h1"));
    titletext = title.getText();
    Assert.assertEquals("Conversation", titletext);


    driver.get("https://thefeedfeed.com/community");
    System.out.println("community opened");
    Thread.sleep(3000);
    title = driver.findElement(By.tagName("h1"));
    titletext = title.getText();
    Assert.assertEquals("All Editors", titletext);


    driver.get("https://thefeedfeed.com/partners");
    System.out.println("partners opened");
    Thread.sleep(3000);
    title = driver.findElement(By.tagName("h1"));
    titletext = title.getText();
    Assert.assertEquals("All Partners", titletext);




};

@AfterClass
    public static void tearDown(){
    System.out.println("Test end");
};

}
