package com.egemsoft;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * EGEMSOFT - Basit Selenium Başlangıç Örneği
 * 
 * Bu sınıf, Selenium tarayıcısının nasıl başlatıldığını göstermek amacıyla yazılmıştır.
 */
public class AutomationTest {

    @Test
    public void testBrowserLaunch() {
        System.out.println("=== EGEMSOFT Selenium Başlatılıyor ===");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://automationexercise.com/");
            System.out.println("Sayfa Başlığı: " + driver.getTitle());
        } finally {
            driver.quit();
            System.out.println("=== Tarayıcı Kapatıldı ===");
        }
    }
}
