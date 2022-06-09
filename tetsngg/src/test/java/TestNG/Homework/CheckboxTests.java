package TestNG.Homework;
import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.Should;
import com.codeborne.selenide.commands.ShouldBe;
import com.codeborne.selenide.conditions.Checked;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;


@Listeners({ SoftAsserts.class})
public class CheckboxTests {
    SoftAssert assertion = new SoftAssert();

    @BeforeMethod
    public void Initialize() {
        getAndCheckWebDriver();
    }

    @BeforeSuite
    public void setup() {

        TestNG.Homework.ConfigTests configTests = new TestNG.Homework.ConfigTests();
        configTests.setup();
        ChromeOptions paraMetres = new ChromeOptions();
        paraMetres.addArguments("start-maximized");
        baseUrl = "http://the-internet.herokuapp.com/checkboxes";
        Configuration.browserCapabilities = paraMetres;
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = null;
        timeout = 8000;
        fastSetValue = false;
        savePageSource = false;
        holdBrowserOpen = true;
        reopenBrowserOnFail = true;
        reportsFolder = "src/main/resources/CheckboxFailedTests";
    }

    @Test(invocationCount = 0, timeOut = 15)
    public void test1(){
        open("");
        SelenideElement secondBox = $$("input").get(1);
        secondBox.setSelected(false);
        secondBox.shouldBe(Condition.checked);
    }

    @Test(priority = 1)
    public void test2(){
        SelenideElement firstBox =   $$("input").first();
        firstBox.setSelected(false);
        firstBox.is(Condition.enabled);
    }

    @AfterMethod
    public void ShutDown() {
        getWebDriver().close();
    }
}