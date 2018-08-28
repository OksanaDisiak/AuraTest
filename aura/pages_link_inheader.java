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

public class pages_link_inheader {

    public static WebDriver driver;

    @BeforeClass
    public static void setup()
    {

        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.HOURS);

    }

    @Test
    public void pages_link_test() throws InterruptedException{

        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);

        //logo
        WebElement logo;
        WebElement homePageh1_logo;
        String homePageh1_text_logo;
        logo = driver.findElement(By.cssSelector("a.logo"));
        logo.click();
        Thread.sleep(2000);
        homePageh1_logo = driver.findElement(By.tagName("h1"));
        homePageh1_text_logo = homePageh1_logo.getText();
        Assert.assertEquals("Trending Feeds", homePageh1_text_logo);
        System.out.println("logo was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //title
        WebElement title;
        WebElement homePageh1_title;
        String homePageh1_text_title;
        WebElement title_site_name;
        String site_name;
        WebElement title_site_description;
        String site_description;
        title_site_name = driver.findElement(By.cssSelector("span.site-name"));
        site_name = title_site_name.getText();
        Assert.assertEquals("feedfeed", site_name);
        title_site_description = driver.findElement(By.cssSelector("span.site-description"));
        site_description = title_site_description.getText();
        Assert.assertEquals("connecting people who love to cook", site_description);
        title = driver.findElement(By.cssSelector("a.title"));
        title.click();
        Thread.sleep(2000);
        homePageh1_title = driver.findElement(By.tagName("h1"));
        homePageh1_text_title = homePageh1_title.getText();
        Assert.assertEquals("Trending Feeds", homePageh1_text_title);
        System.out.println("logo was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        /*PAGES LINK IN HEADER MENU - feeds, stories, videos etc like elements in list.
            0 - feeds
            1 - stories
            2 - videos
            3 - tv - don`t use
            4 - conversations
            5 - community
            6 - partner
        */

        List<WebElement> pages_menu;


        //feeds
        pages_menu = driver.findElements(By.cssSelector("a.navigation-item"));
        WebElement feeds = pages_menu.get(0);
        String feeds_text = feeds.getText();
        WebElement feeds_page_h1;
        String feeds_page_h1_text;
        Assert.assertEquals("FEEDS", feeds_text);
        feeds.click();
        Thread.sleep(3000);
        feeds_page_h1 = driver.findElement(By.tagName("h1"));
        feeds_page_h1_text = feeds_page_h1.getText();
        Assert.assertEquals("All Feeds", feeds_page_h1_text);
        System.out.println("feeds link in header menu was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //stories
        pages_menu = driver.findElements(By.cssSelector("a.navigation-item"));
        WebElement stories = pages_menu.get(1);
        String stories_text = stories.getText();
        Assert.assertEquals("STORIES", stories_text);
        stories.click();
        Thread.sleep(3000);
        WebElement stories_page_h1;
        String stories_page_h1_text;
        stories_page_h1 = driver.findElement(By.tagName("h1"));
        stories_page_h1_text = stories_page_h1.getText();
        Assert.assertEquals("All Stories", stories_page_h1_text);
        System.out.println("stories link in header menu was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //videos
        pages_menu = driver.findElements(By.cssSelector("a.navigation-item"));
        WebElement videos = pages_menu.get(2);
        String videos_text = videos.getText();
        WebElement videos_page_h1;
        String videos_page_h1_text;
        Assert.assertEquals("VIDEOS", videos_text);
        videos.click();
        Thread.sleep(3000);
        videos_page_h1 = driver.findElement(By.tagName("h1"));
        videos_page_h1_text = videos_page_h1.getText();
        Assert.assertEquals("All Videos", videos_page_h1_text);
        System.out.println("videos link in header menu was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //TV - passed, will maked later


        //conversation
        pages_menu = driver.findElements(By.cssSelector("a.navigation-item"));
        WebElement conversations = pages_menu.get(4);
        String conversations_text = conversations.getText();
        WebElement conversations_page_h1;
        String conversations_page_h1_text;
        Assert.assertEquals("CONVERSATIONS", conversations_text);
        conversations.click();
        Thread.sleep(3000);
        conversations_page_h1 = driver.findElement(By.tagName("h1"));
        conversations_page_h1_text = conversations_page_h1.getText();
        Assert.assertEquals("Conversation", conversations_page_h1_text);
        System.out.println("conversation link in header menu was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //community
        pages_menu = driver.findElements(By.cssSelector("a.navigation-item"));
        WebElement community = pages_menu.get(5);
        String community_text = community.getText();
        WebElement community_page_h1;
        String community_page_h1_text;
        Assert.assertEquals("COMMUNITY", community_text);
        community.click();
        Thread.sleep(3000);
        community_page_h1 = driver.findElement(By.tagName("h1"));
        community_page_h1_text = community_page_h1.getText();
        Assert.assertEquals("All Editors", community_page_h1_text);
        System.out.println("community link in header menu was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);


        //partners
        pages_menu = driver.findElements(By.cssSelector("a.navigation-item"));
        WebElement partners = pages_menu.get(6);
        String partners_text = partners.getText();
        WebElement partners_page_h1;
        String partners_page_h1_text;
        Assert.assertEquals("PARTNERS", partners_text);
        partners.click();
        Thread.sleep(3000);
        partners_page_h1 = driver.findElement(By.tagName("h1"));
        partners_page_h1_text = partners_page_h1.getText();
        Assert.assertEquals("All Partners", partners_page_h1_text);
        System.out.println("partners link in header menu was checked");
        driver.get("https://thefeedfeed.com/");
        Thread.sleep(2000);

    }

    @AfterClass
    public static void end_test(){
        System.out.println("TEST OF PAGES LINKS IN HEADER MENU ENDED");
    }
}
