package zadanie2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class zadanie2 {
    @Test
    public void  shopping() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl.");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement signInButton = driver.findElement(By.className("user-info"));
        signInButton.click();

        WebElement searchEmailInput = driver.findElement(By.name("email"));
        searchEmailInput.sendKeys("oliv.testy@ok.pl");
        WebElement searchPasswordInput = driver.findElement(By.name("password"));
        searchPasswordInput.sendKeys("test123");
        WebElement searchSignIn = driver.findElement(By.id("submit-login"));
        searchSignIn.click();

        WebElement searchClothes = driver.findElement(By.id("category-3"));
        searchClothes.click();

        WebElement searchThisClothes = driver.findElement(By.name("s"));
        searchThisClothes.sendKeys("Hummingbird Printed Sweater");
        searchThisClothes.submit();

        WebElement sweaterIMG = driver.findElement(By.xpath("//img[@alt=\"Brown bear printed sweater\"]"));
        sweaterIMG.click();

        WebElement searchSizeList = driver.findElement(By.id("group_1"));
        searchSizeList.sendKeys("M");

        WebElement searchQuantity = driver.findElement(By.name("qty"));
        //searchQuantity.click();
        searchQuantity.clear();
        searchQuantity.sendKeys("5");

        WebElement searchAddToCard = driver.findElement(By.className("add"));
        searchAddToCard.click();

        WebElement searchProceedToCheckout = driver.findElement(By.xpath("//a[contains(text(),\"Proceed to checkout\")]"));
        searchProceedToCheckout.click();

        WebElement searchProceed2 = driver.findElement(By.xpath("//a[contains(text(),\"Proceed to checkout\")]"));
        searchProceed2.click();


        WebElement ConfirmAddress = driver.findElement(By.name("confirm-addresses"));
        ConfirmAddress.click();

        WebElement ConfirmDelivery = driver.findElement(By.name("confirmDeliveryOption"));
        ConfirmDelivery.click();

        WebElement searchPayByCheck = driver.findElement(By.name("payment-option"));
        searchPayByCheck.click();
        WebElement searchAgreement = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        searchAgreement.click();

        WebElement searchOrderWithObligationToPay = driver.findElement(By.id("payment-confirmation"));
        searchOrderWithObligationToPay.click();

        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":","_");
        Files.copy(tmpScreenshot.toPath(),Paths.get("C:\\kurs Oliwia\\SeleniumCourse\\screenshot",currentDateTime+".png"));

        driver.quit();
    }
}
