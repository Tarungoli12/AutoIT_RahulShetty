package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class FileUploadAutoIT {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ilovepdf.com/jpg_to_pdf");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\91720\\Documents\\UploadFile_AutoIt\\AutoItCommands.exe");
    }
}
