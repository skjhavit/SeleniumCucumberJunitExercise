package stepDefinitions;

import com.gargoylesoftware.htmlunit.Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.TourHomePageAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.FlightFinderPage;
import pageObjects.SelectFlightPage;
import pageObjects.ToursHomePage;
import pageObjects.ToursSignOnPage;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class FlightReservationLoginSteps {
    ToursHomePage page;

    public WebDriver driver;
    public Properties props;


    public FlightReservationLoginSteps() {
        driver = Hooks.driver;
        props = Hooks.props;
    }

    @Given("^user is on (.*)$")
    public void user_is_on(String pageName) {
        driver.get(props.getProperty(pageName));
        page =  PageFactory.initElements(driver, ToursHomePage.class);
    }

    @Then("^image of (.*) is displayed$")
    public void image_is_displayed(String imageName) {
        TourHomePageAction.isImageDisplayed(page,imageName);
    }

    @And("^current date is displayed$")
    public void current_date_is_displayed() throws Throwable{
        TourHomePageAction.isCurrentDateDisplayed(page);
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersInvalidUserNameAndInvalidPassword(String userName, String password) {
        TourHomePageAction.performLoginOperation(page,userName,password);
    }

    @Then("^user lands on sign on page$")
    public void userLandsOnSignOnPage() {
        ToursSignOnPage page = PageFactory.initElements(driver,ToursSignOnPage.class);
        TourHomePageAction.isSignOnPageLoaded(page);
    }

    @Then("^user lands searchFlightPage$")
    public void userLandsSearchFlightPage() {
        FlightFinderPage page = PageFactory.initElements(driver,FlightFinderPage.class);
        TourHomePageAction.isSearchFlightPageLoaded(page);
    }
}
