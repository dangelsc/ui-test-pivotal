import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BadLoginPivotalTest {
    WebDriver driver;
    @Test
    public void loginWithInvalidCredentials(){
        WebDriverManager.chromedriver()/*.driverVersion("60")*/.setup();
        //Initialize chrome driver
        driver = new ChromeDriver();
        //load url
        driver.get("https://www.pivotaltracker.com/signin");
        //locate username webelement
        WebElement usernameTextBox = driver.findElement(By.cssSelector("#credentials_username"));
        //fill username on webelement
        usernameTextBox.sendKeys("dangel.sc@gmail.com");

        //locate action button
        WebElement nextButton = driver.findElement(By.cssSelector(".app_signin_action_button"));
        //clicks on action button
        nextButton.click();
        //locate action password
        WebElement passwordtextBox = driver.findElement(By.cssSelector("#credentials_password"));
        //clicks on action button
        passwordtextBox.sendKeys("5551127_pi1");
        //locate actio button
        WebElement signinButton = driver.findElement(By.cssSelector(".app_signin_action_button"));
        //clicks on action button
        signinButton.click();

        //locate actio profileDropdown
        WebElement errorMessage = driver.findElement(By.cssSelector(".app_signin_error"));


        String actualerror = errorMessage.getText();
        String expectederror = "Invalid username/password";
        Assert.assertEquals(actualerror,expectederror);
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
