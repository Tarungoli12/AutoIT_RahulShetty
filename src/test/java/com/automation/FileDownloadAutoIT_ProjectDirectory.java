package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class FileDownloadAutoIT_ProjectDirectory {

    @Test
    public void test() throws IOException, InterruptedException {
        String downloadPath = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        HashMap<String,Object> map = new HashMap<>();
        map.put("download.default_directory",downloadPath);
        options.setExperimentalOption("prefs",map);

        WebDriver driver = new ChromeDriver(options);
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
        Thread.sleep(3000);
        File file = new File(downloadPath+"/Document.pdf");
        if (file.exists()) {
            System.out.println("File downloaded successfully..........");
        }
        if(file.delete()) {
            System.out.println("File deleted successfully........");
        }
    }
}
