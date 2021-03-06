package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
//Driver class, driver instance'i baslatmak icin kullanilir.(Sinngleton Driver)
//Ihtiyacimiz oldugunda driver'i kurmak ve baslatmak icin kullaniriz.
//Driver null oldugunda create edip baslatacagiz.(if driver==null)
//Driver classi farkli browserlar(tarayici) ile de kullanacagimiz sekilde olusturacagiz.




//driver instance olusturalim


    static WebDriver driver;
    //Baska obje olusturulmasini istemedigimiz icin creat ediyoruz
//driver'i baslatmak icin statik bir metod olusturalim
    public static WebDriver getDriver(){

        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver=new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;


            }
// WebDriverManager.chromedriver().setup();
// driver=new ChromeDriver();
        }
// driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // eger driver chrome a isaret ediyorsa driver kapat..
            driver.quit();

            driver = null; // driver in null oldugundan emin olmak icin tekrar null olarak atayalim ...

// boylelikle drive i tekrar baslatabiliriz ve Multi Browser Test (chrome,firefox ie ..) yaparken bu onemli


        }

    }
}
