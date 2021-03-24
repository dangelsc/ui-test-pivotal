package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class LoginPivotalTest {
    WebDriver driver;
    @Test
    public void loginWithValidCredentials(){
        //descarga el firefox, configura y demas
       /* WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");*/
        //configure chrome driver
        WebDriverManager.chromedriver()/*.driverVersion("60")*/.setup();
        //Initialize chrome driver
        driver = new ChromeDriver();
        //load url
        driver.get("https://www.pivotaltracker.com/signin");
        //locate username webelement
        WebElement usernameTextBox = driver.findElement(By.cssSelector("#credentials_username"));
        //fill username on webelement
        usernameTextBox.sendKeys("dangel.sc@gmail.com");

        //locate actio button
        WebElement nextButton = driver.findElement(By.cssSelector(".app_signin_action_button"));
        //clicks on action button
        nextButton.click();
        //locate action password
        WebElement passwordtextBox = driver.findElement(By.cssSelector("#credentials_password"));
        //clicks on action button
        passwordtextBox.sendKeys("5551127_pi");
        //locate actio button
        WebElement signinButton = driver.findElement(By.cssSelector(".app_signin_action_button"));
        //clicks on action button
        signinButton.click();

        //locate actio profileDropdown
        WebElement profileDropdown = driver.findElement(By.cssSelector("*[aria-label=\"Profile Dropdown\"]"));
        //clicks on action button
        //assert username
        String actualUsername = profileDropdown.getText();
        String expectedUsername = "dangelsc";
        //Assert.assertEquals(actualUsername,expectedUsername);
        Assert.assertTrue(actualUsername.equalsIgnoreCase(expectedUsername));
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
