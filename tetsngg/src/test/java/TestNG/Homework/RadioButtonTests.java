package TestNG.Homework;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonTests {

    @BeforeMethod
    public void Initialize() {
        getAndCheckWebDriver();
    }

    public RadioButtonTests(){
        baseUrl = " https://demoqa.com ";
        assertionMode = AssertionMode.SOFT;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "src/main/resources/RadioButtonFailedTests";
        Configuration.reopenBrowserOnFail = true;
        ChromeOptions parametres = new ChromeOptions();
        parametres.addArguments("start-maximized");
    }
    @Test
    public void test1(){
        open("/radio-button");
        $(By.id("yesRadio")).click();
        if($(By.id("noButton")).exists()){
            try{
                $(By.id("noButton")).click();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        SoftAssert assertion = new SoftAssert();
        assertion.assertAll();
    }

    @AfterMethod
    public void ShutDown() {
        getWebDriver().close();
    }
}
