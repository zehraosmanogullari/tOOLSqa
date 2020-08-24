package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


public abstract class TestBase { // abtrackt class yaptik cunku obje uretmeyegiz

// frame work da test base de abstrackt olarak kullandik


    protected WebDriver driver;// protected yaptik cunku baska bir package de ve diger package ulassin diye


    protected Actions actions; // diger paketlerin de ulasabilmesi icin protected olud ve burada instance variable dir

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// bekleme metodo

        actions=new Actions(driver);// driver da calisacagi icin paremetre olarak kondu
// driver icicine yazilmasa hata verir..
    }
    @AfterMethod
    public void tearDown(){
// driver.close();
    }
}