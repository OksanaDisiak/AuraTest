package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class homepage_test {

    public static WebDriver driver;

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.HOURS);

    }

    @Test
    public void homepage_rest() throws InterruptedException {

        driver.get("https://thefeedfeed.com/");
        List<WebElement> social_links;


        //twitter

        WebElement twitter;
        social_links = driver.findElements(By.cssSelector("a.social-link"));
        twitter = social_links.get(0);
        twitter.click();
        Thread.sleep(3500);

        Set<String> windowHandlers_twitter = driver.getWindowHandles();
        for (String windowHandler_twitter : windowHandlers_twitter) {
            driver.switchTo().window(windowHandler_twitter);
            if (driver.getCurrentUrl().equals("https://twitter.com/the_feedfeed")) {

                WebElement twitter_check = driver.findElement(By.tagName("h1"));
                String twitter_profile_name = twitter_check.getText();
                Assert.assertEquals("feedfeed Julie & Dan", twitter_profile_name);
                System.out.println("twitter link in header menu was checked");
                Thread.sleep(3500);

                break;
            }
        }

        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //tumblr

        social_links = driver.findElements(By.cssSelector("a.social-link"));
        WebElement tumblr;
        tumblr = social_links.get(1);
        tumblr.click();
        Thread.sleep(3500);

        Set<String> windowHandlers_tumblr = driver.getWindowHandles();
        for (String windowHandler_tumblr : windowHandlers_tumblr) {
            driver.switchTo().window(windowHandler_tumblr);
            if (driver.getCurrentUrl().equals("https://thefeedfeed.tumblr.com/")) {

                WebElement
                        tumblr_check = driver.findElement(By.cssSelector("h1.blog-title"));
                String tumbler_profile_name = tumblr_check.getText();
                Assert.assertEquals("feedfeed", tumbler_profile_name);
                System.out.println("tumblr link in header menu was checked");
                Thread.sleep(3500);

                break;
            }
        }

        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //pinterest

        WebElement pinterest;
        social_links = driver.findElements(By.cssSelector("a.social-link"));
        pinterest = social_links.get(2);
        pinterest.click();
        Thread.sleep(3500);

        Set<String> windowHandlers_pinterest = driver.getWindowHandles();
        for (String windowHandler_pinterest : windowHandlers_pinterest) {
            driver.switchTo().window(windowHandler_pinterest);
            if (driver.getCurrentUrl().equals("https://www.pinterest.com/feedfeed/")) {

                WebElement pinterest_check = driver.findElement(By.className("_w3"));
                String pinterest_profile_name = pinterest_check.getText();
                Assert.assertEquals("feedfeed", pinterest_profile_name);
                System.out.println("pinterest link in header menu was checked");
                Thread.sleep(3500);

                break;
            }
        }

        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //facebook

        social_links = driver.findElements(By.cssSelector("a.social-link"));
        WebElement facebook;
        facebook = social_links.get(3);
        facebook.click();
        Thread.sleep(3500);

        Set<String> windowHandlers_facebook = driver.getWindowHandles();
        for (String windowHandler_facebook : windowHandlers_facebook) {
            driver.switchTo().window(windowHandler_facebook);
            if (driver.getCurrentUrl().equals("https://www.facebook.com/thefeedfeed/")) {

                WebElement
                        facebook_check = driver.findElement(By.tagName("h1"));
                String facebook_profile_name = facebook_check.getText();
                Assert.assertEquals("feedfeed", facebook_profile_name);
                System.out.println("facebook link in header menu was checked");
                Thread.sleep(3500);

                break;
            }
        }

        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //snapchat

        WebElement snapchat;
        social_links = driver.findElements(By.cssSelector("a.social-link"));
        snapchat = social_links.get(4);
        snapchat.click();
        Thread.sleep(3500);

        Set<String> windowHandlers_snapchat = driver.getWindowHandles();
        for (String windowHandler_snapchat : windowHandlers_snapchat) {
            driver.switchTo().window(windowHandler_snapchat);
            if (driver.getCurrentUrl().equals("https://www.pinterest.com/feedfeed/")) {

                WebElement snapchat_check = driver.findElement(By.cssSelector("div.css-1jnqnk2"));
                String snapchat_profile_name = snapchat_check.getText();
                Assert.assertEquals("thefeedfeed", snapchat_profile_name);
                System.out.println("snapchat link in header menu was checked");
                Thread.sleep(3500);

                break;
            }
        }

        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);

    }

    @AfterClass
    public static void endtest(){
        System.out.println("TEST END");

    }
}
