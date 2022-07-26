package zadanie1address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class zadanie1addresssteps {
    private WebDriver driver;

    @Given("Browser with open page at address https:\\/\\/mystore-testlab.coderslab.pl")
    public void browser_with_open_page_at_address_https_mystore_testlab_coderslab_pl() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl.");
    }

    @When("Log in as an existing user")
    public void signedIn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement signInButton = driver.findElement(By.className("user-info"));
        signInButton.click();

        WebElement searchEmailInput= driver.findElement(By.name("email"));
        searchEmailInput.sendKeys("oliv.testy@ok.pl");
        WebElement searchPasswordInput= driver.findElement(By.name("password"));
        searchPasswordInput.sendKeys("test123");
        WebElement searchSignIn= driver.findElement(By.id("submit-login"));
        searchSignIn.click();
    }

    @And("Address clicked")
    public void newAddressClicked() {
       WebElement addAddress = driver.findElement(By.id("addresses-link"));
        addAddress.click();
    }
    @And("Create New Address")
    public void newAddress(){
        WebElement newAddress = driver.findElement(By.xpath("//*[contains(text(),\"Create new address\")]"));
        newAddress.click();
    }
    @And ("^Alias (.*)$")
    public void searchAliasInput(String Alias){
        WebElement searchAliasInput = driver.findElement(By.name("alias"));
        searchAliasInput.sendKeys(Alias);
    }

    @And("^Address added (.*)$")
    public void searchAddressInput(String Address) {
        WebElement searchAddressInput = driver.findElement(By.name("address1"));
        searchAddressInput.sendKeys(Address);
    }
    @And("^City added(.*)$")
    public void searchCityInput(String City) {
        WebElement searchCityInput = driver.findElement(By.name("city"));
        searchCityInput.sendKeys(City);
    }


    @And("^Postal Code(.*)$")
    public void searchPostalcodeInput(String PostalCode) {
        WebElement searchPostalcodeInput = driver.findElement(By.name("postcode"));
        searchPostalcodeInput.sendKeys(PostalCode);
    }

    @And("^Phone(.*)$")
    public void searchPhoneInput(String Phone) {
        WebElement searchPhoneInput = driver.findElement(By.name("phone"));
        searchPhoneInput.sendKeys(Phone);
    }
    @And("Country")
    public void searchCountryInput() {
        WebElement searchCountryInput = driver.findElement(By.name("id_country"));
        searchCountryInput.sendKeys("United Kingdom");
    }

    @And("Save")
    public void SaveInformation(){
        WebElement searchSaveButton = driver.findElement(By.xpath("//*[contains(text(),\"Save\")]"));
        searchSaveButton.click();
    }


    }

