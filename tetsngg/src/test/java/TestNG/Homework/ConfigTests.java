package TestNG.Homework;
import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.*;

@Listeners({ SoftAsserts.class})
public class ConfigTests {

    @BeforeSuite
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = null;
        timeout = 8000;
        holdBrowserOpen=true;
        reopenBrowserOnFail = true;
        fastSetValue=false;
        savePageSource=false;
    }
}