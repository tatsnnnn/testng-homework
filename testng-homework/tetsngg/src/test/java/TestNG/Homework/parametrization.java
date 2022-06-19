package TestNG.Homework;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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


import static java.nio.channels.FileChannel.open;

public class parametrization extends Configurations {
    @Test
    @Parameters({"firstName","lastName","gender","mobileNumber"})

    public void Custom_Test(String firstName, String lastName, String gender, String mobileNumber) {

        open("https://demoqa.com/automation-practice-form");
        SelenideElement first = $("input[id=firstName]");
        SelenideElement last = $("input[id=lastName]");

        first.setValue(firstName);
        last.setValue(lastName);

        $("input[value="+gender+"]").parent().scrollTo().click();
        $("input[id=userNumber]").setValue(mobileNumber);

        first_name.shouldHave(value(firstName));
        last_name.shouldHave(value(lastName));
    }
}
