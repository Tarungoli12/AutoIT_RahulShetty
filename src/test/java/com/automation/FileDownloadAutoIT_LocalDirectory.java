package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FileDownloadAutoIT_LocalDirectory {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ilovepdf.com/jpg_to_pdf");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\91720\\Documents\\UploadFile_AutoIt\\AutoItCommands.exe");
        By convertToPdfButton = By.cssSelector("button[id='processTask']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(convertToPdfButton));
        driver.findElement(convertToPdfButton).click();
        By downloadButton = By.id("pickfiles");
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
        driver.findElement(downloadButton).click();
        File file = new File("C:\\Users\\91720\\Downloads\\Document.pdf");
        if (file.exists()) {
            System.out.println("File downloaded successfully..........");
        }
    }
}
