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
    public void testTest3() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0051");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TATIANA  SH");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("08");
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2024");
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("111");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("payment-status")).click();
        assertEquals("Info", driver.findElement(By.xpath("//div[@id='payment-status-title']/span")).getText());
        driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).click();
        assertEquals("CONFIRMED", driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).getText());

    }
    @Test
    public void testTest4() throws Exception {
    driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4477");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TATIANA  SH");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("03");
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2028");
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("111");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).click();
        assertEquals("Declined by issuing bank", driver.findElement(By.xpath("//div[@id='payment-item-status']/div[2]")).getText());
        driver.findElement(By.xpath("//div[@id='payment-item-cardnumber']/div[2]")).click();
        assertEquals("...4477", driver.findElement(By.xpath("//div[@id='payment-item-cardnumber']/div[2]")).getText());
        driver.findElement(By.xpath("//div[@id='payment-item-cardtype']/div[2]")).click();
        assertEquals("MASTERCARD", driver.findElement(By.xpath("//div[@id='payment-item-cardtype']/div[2]")).getText());
        }

    @Test
    public void testTest5() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("input-card-number")).click();
    driver.findElement(By.id("input-card-number")).clear();
    driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0077");
    driver.findElement(By.id("input-card-holder")).click();
    driver.findElement(By.id("input-card-holder")).clear();
    driver.findElement(By.id("input-card-holder")).sendKeys("TATIANA  SH");
    driver.findElement(By.id("card-expires-month")).click();
    new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("03");
    driver.findElement(By.id("card-expires-year")).click();
    new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2027");
    driver.findElement(By.id("input-card-cvc")).click();
    driver.findElement(By.id("input-card-cvc")).clear();
    driver.findElement(By.id("input-card-cvc")).sendKeys("444");
    driver.findElement(By.id("action-submit")).click();
    driver.findElement(By.xpath("//div[@id='payment-item-authcode']/div[2]")).click();
    assertEquals("DpQt5d", driver.findElement(By.xpath("//div[@id='payment-item-authcode']/div[2]")).getText());
    driver.findElement(By.xpath("//div[@id='payment-item-cardnumber']/div[2]")).click();
    assertEquals("...0077", driver.findElement(By.xpath("//div[@id='payment-item-cardnumber']/div[2]")).getText());
}
    @Test
    public void testTest6() throws Exception {
        driver.get(baseUrl);
driver.findElement(By.id("input-card-number")).click();
    driver.findElement(By.id("input-card-number")).clear();
    driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0077");
    driver.findElement(By.id("input-card-holder")).click();
    driver.findElement(By.id("input-card-holder")).clear();
    driver.findElement(By.id("input-card-holder")).sendKeys("TATIANA  SH");
    driver.findElement(By.id("card-expires-month")).click();
    new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("03");
    driver.findElement(By.id("card-expires-year")).click();
    new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2030");
    driver.findElement(By.id("input-card-cvc")).click();
    driver.findElement(By.id("input-card-cvc")).clear();
    driver.findElement(By.id("input-card-cvc")).sendKeys("444");
    driver.findElement(By.id("action-submit")).click();
    driver.findElement(By.xpath("//div[@id='payment-item-authcode']/div[2]")).click();
    assertEquals("eNC3JW", driver.findElement(By.xpath("//div[@id='payment-item-authcode']/div[2]")).getText());
    driver.findElement(By.xpath("//div[@id='payment-item-cardnumber']/div[2]")).click();
    assertEquals("...0077", driver.findElement(By.xpath("//div[@id='payment-item-cardnumber']/div[2]")).getText());
}
    @Test
    public void testTest7() throws Exception {
        driver.get(baseUrl);
driver.findElement(By.id("input-card-number")).click();
    driver.findElement(By.id("input-card-number")).clear();
    driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0093");
    driver.findElement(By.id("input-card-holder")).click();
    driver.findElement(By.id("input-card-holder")).clear();
    driver.findElement(By.id("input-card-holder")).sendKeys("TATIANA  SH");
    driver.findElement(By.id("card-expires-month")).click();
    new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("05");
    driver.findElement(By.id("card-expires-year")).click();
    new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2029");
    driver.findElement(By.id("input-card-cvc")).click();
    driver.findElement(By.id("input-card-cvc")).clear();
    driver.findElement(By.id("input-card-cvc")).sendKeys("444");
    driver.findElement(By.id("action-submit")).click();
    driver.get("https://sandbox.cardpay.com/MI/3ds2/result.html?orderMd=3d21a08e-0e43-45ba-84a9-8643229df68e");
    driver.findElement(By.xpath("//div[@id='payment-item-authcode']/div[2]")).click();
    assertEquals("diox06", driver.findElement(By.xpath("//div[@id='payment-item-authcode']/div[2]")).getText());
    driver.findElement(By.xpath("//div[@id='payment-item-total']/div[2]")).click();
    assertEquals("291.86", driver.findElement(By.id("payment-item-total-amount")).getText());
}


    @After
    public void tearDown() throws Exception {
        driver.quit();

    }

}
