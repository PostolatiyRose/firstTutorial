package onfreetube;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

/**
 * Unit test for simple App.
 */
//public class AppTest {

    /**
     * Rigorous Test :-)
     */
   // @Test
   // public void shouldAnswerWithTrue() {
 //       assertTrue(true);
 //   }
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("troyanda12");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("195073");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("troyanda12@ukr.net", mailUser);
    }
    @AfterClass
    public static void tearDown() {
        WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();
        driver.quit();
    }
}
