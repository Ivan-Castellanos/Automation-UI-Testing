package com.solvd;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {

    private WebDriver driver;
    private final static Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testSearch(){
        WebElement searchbox = driver.findElement(By.id("search_query_top"));
        searchbox.clear();
        searchbox.sendKeys("printed");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        List<WebElement> count = driver.findElements(By.className("product-container"));
        LOGGER.info("There are " + count.size() + " coincident elements.");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}