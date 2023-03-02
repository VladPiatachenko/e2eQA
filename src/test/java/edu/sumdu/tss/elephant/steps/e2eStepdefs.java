package edu.sumdu.tss.elephant.steps;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import io.cucumber.java8.En;
import org.openqa.selenium.WebElement;

public class e2eStepdefs implements En {
    public e2eStepdefs() {
        Given("^open elephant login page \"([^\"]*)\"$", (String arg0) -> {
            open(arg0);
        });
        And("^type into email \"([^\"]*)\"$", (String arg0) -> {
            $(byName("login")).setValue(arg0);
        });
        And("^type into password \"([^\"]*)\"$", (String arg0) -> {
            $(byName("password")).setValue(arg0);
        });
        When("^press button with text login on login page$", () -> {
            $(byXpath("/html/body/main/div[1]/div/div[2]/form/button")).click();
        });
        Then("^redirect to profile page \"([^\"]*)\"$", (String arg0) -> {
            String currentUrl=url();
            assertEquals(currentUrl,arg0);
        });
        When("^press button with eye symbol on login page$", () -> {
            $(byXpath("//*[@id=\"basic-addon2\"]")).click();
        });
        Then("^password changed to readable text$", () -> {
            WebElement pass= $(byXpath("//*[@id=\"floatingPassword\"]")).getWrappedElement();
            String type=pass.getAttribute("type");
            assertEquals(type,"text");//"or password if encapsulated"
        });
        And("^press button \"([^\"]*)\"$", (String arg0) -> {
            WebElement ref= $(byXpath(arg0));
            ref.click();
        });
    }
}
