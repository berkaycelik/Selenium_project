package base;


import javafx.scene.web.WebEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class BaseTest {
    public WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\berka\\Documents\\chormedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    }
    @Test
    public void TestHome(){

        WebElement signbutton= driver.findElement(By.xpath("/html//header[@id='main-header']/div/div/div/div/div/div/div/div[@title='Giriş Yap']/div[@class='gekhq4-4 hwMdSM']"));
        signbutton.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        WebElement mailbox= driver.findElement(By.id("L-UserNameField"));
        mailbox.click();
        mailbox.sendKeys("berkay.celik.testing@hotmail.com");

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("Testinium321");
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.findElement(By.id("gg-login-enter")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.xpath("/html//header[@id='main-header']/div/div/div/div//form[@action='https://www.gittigidiyor.com/arama']//input[@name='k']"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        WebElement SearchClick = driver.findElement(By.cssSelector(".hKfdXF.qjixn8-0.sc-1bydi5r-0 > span"));
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        List<WebElement> links = driver.findElements(By.cssSelector(".catalog-view.products-container > li"));
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//div[@id='best-match-right']/div[5]/ul/li[2]/a[@href='/arama/?k=bilgisayar&sf=2']")).click();
        links.subList(0, 10).clear();
        WebElement price= driver.findElement(By.id("sp-price-lowPrice");
        String priceText= price.getText();

        Random rand = new Random();
        int randIndex = rand.nextInt(links.size());

        int offset = 0;
        while(true) {
            try {
                WebEngine scroll = null;
                scroll.executeScript("window.scrollTo(0, " + offset + ")");
                thread(2000);
                links.get(randIndex).click();
                break;
            } catch (ElementClickInterceptedException e) {
                offset += 900;
            }
        }
        WebElement AddBasket = driver.findElement(By.id("add-to-basket"));
        AddBasket.click();
        WebElement priceBasket= driver.findElement(By.xpath("/html//div[@id='header_wrapper']/div/div//ul/li//span[@class='product-new-price']"));
        String priceText2= priceBasket.getText();
        if(priceText.compareTo(priceText2)>0){

            WebElement quantityBasket = driver.findElement(By.className("IncNumber gg-icon gg-icon-plus");
            quantityBasket.click();



        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".row > a[title='Sil'] > .gg-icon.gg-icon-bin-medium")).click();
    }

    private void thread(int i) {
    }

    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.quit();
    }


   
}
