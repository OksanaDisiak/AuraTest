package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
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

public class stories_test {

    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/aura/IdeaProjects/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.HOURS);
        }

    @Test
    public void test() throws InterruptedException{
        driver.get("https://thefeedfeed.com/stories"); //переходим по ссылке на страницу историй

        System.out.println("Скроллим");
        for (int second = 0;; second++) {    /// я не знаю, что тут происходит, но оно прокручивает страницу вниз
            if(second >=132){
                break;
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(1000);
        }
        Thread.sleep(1000); //ждем-с если что-то не прогрузилось, долго ждем

        System.out.println("Инициализируем списки");
        List <WebElement> stories_refs = driver.findElements(By.className("story-link")); //находим все элементы - ссылки на истории
        List<String> stories_title = new ArrayList<String>(); // список всех title историй
        List<String> stories_href = new ArrayList<String>(); // список всех ссылок href историй, по которым будем переходить

        System.out.println("Ищем элементы и записываем значения в массив:");
        System.out.println(" ");
        System.out.println(" ");
        for(int i = 0; i < stories_refs.size(); i++){ //извлекаем в списки ВСЕ тайтлы и ссылки на истории
            // (лучше конечно один список-класс сделать, но не сегодня)
            stories_href.add(stories_refs.get(i).getAttribute("href"));
            stories_title.add(stories_refs.get(i).getText());
            System.out.println( i + "." + stories_title.get(i) + ":  " + stories_href.get(i));
    }

    //а тут пиздец. Будм открывать каждую ссылку и сравнивать тайтл
        // - если он совпадает, то все ок. Если не совпадает - ставим минус напротив номера

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Пытаемся открыть ссылки на истории:");
        System.out.println(" ");
        System.out.println(" ");

        WebElement h1;
        String title_page;

        for(int k = 0; k < stories_refs.size(); k++){
            if(    /* k == 9 || k == 13 || k == 14 || k == 15 || k == 21 || k == 24 || k == 31 || k == 36 || k == 37 ||
                    k == 40 || k == 46 || k == 52 || k == 68 || k ==  73 || k ==  75 || k ==  77 || k ==  79  ||
                    k ==  84 || k ==  86 || k ==  90 || k ==  91 || k ==  93 || k ==  97 || k ==  98 ||
                    k == 101 || k == 110 || k == 113 || k == 115 || k == 117 || k == 118 || k == 119 || k == 129 || k == 130 ||
                            k == 133 || k == 136 || k == 137 || k == 150 || k ==  153 || k ==  154 || k ==  156 || k ==  166 ||
                            k ==  171 || k ==  172 || k ==  180 || k ==  181 || k ==  182 || k ==  187 || k ==  188
                            || k ==  190 || k ==  191 || k ==  193 || k ==  194 || k ==  196 ||
                    k == 200 || k == 203 || k == 205 || k == 209 || k == 212 || k == 219 || k == 220 || k == 224 || k == 232 ||
                            k == 234 || k == 239 || k == 240 || k == 241 || k ==  244 || k ==  246 || k ==  249 || k ==  250 ||
                            k ==  84 || k ==  86 || k ==  90 || k ==  91 || k ==  93 || k ==  97 || k ==  98 ||
                    k == 252 || k == 253 || k == 259 || k == 263 || k == 264 || k == 266 || k == 268 || k == 271 || k == 275 ||
                    k == 286 || k == 290 || k == 291 ||
                    k == 301 || k == 306 || k == 308 || k == 310 || k == 316 || k == 332 || k == 334 || k == 335 || k == 336 ||
                            k == 337 || k == 341 || k == 347 || k == 352 || k ==  375 || k ==  381 || k ==  388 || k ==  391 ||
                            k ==  393 || k ==  394 || k ==  395 || k ==  400
                    k == 402 || k == 407 || k == 410 || k == 412 || k == 413 || k == 416 || k == 417 || k == 418 || k == 419 ||
                            k == 4stories_title.get(k)20 || k == 421 || k == 426 ||
                            k == 428 || k == 429 || k == 432 || k == 434 || k == 435 || k == 444 || k == 447 || k == 453 || k == 458
                            || k == 459 || k == 467 || k == 475 || k == 477 || k == 486 || k == 491 || k == 496 || k == 497
                    k == 501 || k == 503 || k == 509 ||
                            k == 510 || k == 511 || k == 512 || k == 513 */
            true
                    ) {
                driver.get(stories_href.get(k));
                Thread.sleep(4000);
                h1 = driver.findElement(By.tagName("h1"));
                title_page = h1.getText();

                String s = title_page.toLowerCase();
                String s1 = stories_title.get(k).toLowerCase();

            if(!s1.startsWith(s))
            {
                //System.out.println( k + "." + stories_title.get(k) + ":  " + stories_href.get(k) + " - REDIRECT");
                System.out.println( k + "." + stories_title.get(k) + " != " + title_page + " - REDIRECT");
            }
           // else  System.out.println( k + "." + stories_title.get(k) + ":  " + stories_href.get(k) + " - ALL RIGHT");

            Thread.sleep(4000);
            }
            else continue;

        }



    }

    @AfterClass
    public static void endtest(){
    System.out.println("TEST END");
    }
}
