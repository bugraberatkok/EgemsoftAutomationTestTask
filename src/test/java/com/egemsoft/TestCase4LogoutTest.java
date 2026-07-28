package com.egemsoft;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * EGEMSOFT Test Otomasyon Ödevi
 * 
 * Görev: Test Case 4 - Logout User (Kullanıcı Çıkış Testi)
 * Site: http://automationexercise.com
 * 
 * Lütfen aşağıdaki 10 adımı Selenium kütüphanesini kullanarak kodlayınız:
 * 
 * 1. Tarayıcıyı başlatın (Launch browser)
 * 2. 'http://automationexercise.com' adresine gidin
 * 3. Ana sayfanın başarıyla görüntülendiğini doğrulayın (Verify home page is visible)
 * 4. 'Signup / Login' butonuna tıklayın
 * 5. 'Login to your account' yazısının görünür olduğunu doğrulayın
 * 6. Geçerli e-posta adresi ve şifre girin
 * 7. 'login' butonuna tıklayın
 * 8. 'Logged in as username' yazısının görünür olduğunu doğrulayın
 * 9. 'Logout' butonuna tıklayın
 * 10. Kullanıcının login sayfasına yönlendirildiğini doğrulayın
 */
public class TestCase4LogoutTest {


    String url = "https://automationexercise.com/";
    String loginUrl = "https://automationexercise.com/login";
    String email = "deneme115@gmail.com";
    String password = "Deneme115";

    @Test
    public void testLogoutUser() {

        WebDriver driver = new ChromeDriver();
        System.out.println("=== Test Başladı! ===");

        driver.get(url);
        System.out.println("=== Chrome açıldı! ===");
        driver.manage().window().maximize();
        System.out.println("=== Tam ekran yapıldı! ===");

        //Sayfa başarıyla açıldı mı kontrol eder.
        websiteException(driver, url);

        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        signUpLoginButton.isDisplayed();
        System.out.println("=== Signup / Login butonu bulundu! ===");
        signUpLoginButton.click();
        System.out.println("=== Signup / Login butonuna tıklandı! ===");

        WebElement LoginToYourAccountText = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
        LoginToYourAccountText.isDisplayed();
        System.out.println("=== Giriş yap yazısı bulundu! ===");

        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-qa='login-password']"));

        emailInput.isDisplayed();
        System.out.println("=== E-mail girişi bulundu! ===");
        emailInput.sendKeys(email);
        System.out.println("=== E-mail girişi yapıldı! ===");

        passwordInput.isDisplayed();
        System.out.println("=== Password girişi bulundu! ===");
        passwordInput.sendKeys(password);
        System.out.println("=== Password girişi yapıldı! ===");

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.isDisplayed();
        System.out.println("=== Login Butonu bulundu! ===");
        loginButton.click();
        System.out.println("=== Login Butonuna tıklandı! ===");


        WebElement usernameText = driver.findElement(By.xpath("//a[contains(normalize-space(.),'Logged in as') and b[string-length(normalize-space()) > 0]]"));
        usernameText.isDisplayed();
        System.out.println("=== Logged in as username bulundu! ===");

        WebElement logOutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        logOutButton.isDisplayed();
        System.out.println("=== Log out butonu bulundu! ===");
        logOutButton.click();
        System.out.println("=== Log out butonuna tıklandı! ===");

        websiteException(driver, loginUrl);


    }

    public void websiteException(WebDriver driver, String ParameterUrl) {

        String actualUrl = driver.getCurrentUrl();

        if (ParameterUrl.equals(actualUrl)) {
            System.out.println("=== Sayfa başarılı bir şekilde açıldı! ===");
            System.out.println("=== Açılan sayfa: " + actualUrl + " ===");
        } else {
            System.out.println("--- Sayfa açılamadı! ---");
        }
    }
}
