import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

           }

    @Test
    public void FirstTest() throws Exception {
        driver.get(baseUrl);
        WebElement cardNumber = driver.findElement(By.id("input-card-number"));
        WebElement cardHolder = driver.findElement(By.id("input-card-holder"));
        cardNumber.click();
        cardNumber.clear();
        cardNumber.sendKeys("4000 0000 0000 0002");
        cardHolder.click();
        cardHolder.clear();
        cardHolder.sendKeys("TATIANA  SH");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("03");
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2033");
        driver.findElement(By.id("payment-data-card-fields")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("success")).click();
        driver.findElement(By.xpath("//div[@id='payment-status-title']/span")).click();
        driver.findElement(By.xpath("//div[@id='payment-status-title']/span")).click();
        assertEquals("Success", driver.findElement(By.xpath("//div[@id='payment-status-title']/span")).getText());
        driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).click();
        assertEquals("Confirmed", driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).getText());
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TATIANA  SH");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("08");
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2033");
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("444");
        driver.findElement(By.id("action-submit")).click();
        driver.get("https://sandbox.cardpay.com/acs-emulator/dummy?p1=v1&p2=v2");
        driver.findElement(By.id("success")).click();
        driver.get("https://sandbox.cardpay.com/MI/cardpayment2.html?bank_id=sandbox");
        driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).click();
        assertEquals("Declined by issuing bank", driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).getText());
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();

    }

}
