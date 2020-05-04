package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.TourHomePageAction;
import modules.TourSearchPageAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.FlightFinderPage;
import pageObjects.ToursHomePage;

import java.util.Properties;

public class FlightSearchAndSelectionSteps {

    public WebDriver driver;
    public Properties props;


    public FlightSearchAndSelectionSteps() {
        driver = Hooks.driver;
        props = Hooks.props;
    }

    @Given("^user is signed in and lands on (.*)$")
    public void userIsSignedInAndLandsOnSearchPage(String searchPage) {
        driver.get(props.getProperty("tourHomePage"));
        ToursHomePage page = PageFactory.initElements(driver, ToursHomePage.class);
        TourHomePageAction.performLoginOperation(page, "userName", "validPassword");
    }

    @Then("^field DepartingFrom has options (.*) and (.*) available\\.$")
    public void fieldDepartingFromHasOptionsNewYorkAndLondonAvailable(String option1, String option2) {
        FlightFinderPage page = PageFactory.initElements(driver, FlightFinderPage.class);
        TourSearchPageAction.isOptionDisplayed(page,option1);
        TourSearchPageAction.isOptionDisplayed(page,option2);
    }

    @When("^user enter (.*) , (.*) and (.*)$")
    public void userEnterFromToAndServiceClass(String from, String to, String serviceClass) {
        FlightFinderPage page = PageFactory.initElements(driver, FlightFinderPage.class);
        TourSearchPageAction.selectSearchFlightOptions(page,to,from,serviceClass);

    }

    @Then("^user sees SelectFlight page$")
    public void userSeesSelectFlightPage() {
        TourSearchPageAction.isSelectFlightPageLoaded(driver);
    }
}
