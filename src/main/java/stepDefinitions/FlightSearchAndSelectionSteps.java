package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.TourHomePageAction;
import modules.TourSearchAndBookPageAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

import java.util.Properties;

public class FlightSearchAndSelectionSteps {

    public WebDriver driver;
    public Properties props;

    SelectFlightPage selectFlightPage;
    BookFlightPage bookFlightPage;
    ConfirmationPage confirmationPage;


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
        FlightFinderPage finderPage = PageFactory.initElements(driver, FlightFinderPage.class);
        TourSearchAndBookPageAction.isOptionDisplayed(finderPage,option1);
        TourSearchAndBookPageAction.isOptionDisplayed(finderPage,option2);
    }

    @When("^user enter (.*) , (.*) and (.*)$")
    public void userEnterFromToAndServiceClass(String from, String to, String serviceClass) {
        FlightFinderPage page = PageFactory.initElements(driver, FlightFinderPage.class);
        TourSearchAndBookPageAction.selectSearchFlightOptions(page,to,from,serviceClass);
        selectFlightPage = PageFactory.initElements(driver, SelectFlightPage.class);

    }

    @Then("^user sees SelectFlight page$")
    public void userSeesSelectFlightPage() {
        TourSearchAndBookPageAction.isSelectFlightPageLoaded(driver);
    }

    @Then("^user sees flights displayed are shorted based on price$")
    public void userSeesFlightsDisplayedAreShortedBasedOnPrice() {
        TourSearchAndBookPageAction.isFlightSortedByPrice(selectFlightPage);
    }

    @And("^header sections are centrally alligned$")
    public void headerSectionsAreCentrallyAlligned() {
        TourSearchAndBookPageAction.areHeadersAligned(selectFlightPage);
    }

    @And("^Background color is (.*)$")
    public void backgroundColorIsBlue(String color) {
        TourSearchAndBookPageAction.doesHeaderColorMatches(selectFlightPage,color);
    }

    @And("^user selects flight having second highest price$")
    public void userSelectsFlightHavingSecondHighestPrice() {
        TourSearchAndBookPageAction.selectSecondHeighestPrice(selectFlightPage);
        bookFlightPage = PageFactory.initElements(driver,BookFlightPage.class);
    }

    @Then("^details of review page is same as select flight page$")
    public void detailsOfReviewPageIsSameAsSelectFlightPage() {
        TourSearchAndBookPageAction.verifyAllBookingDetails(bookFlightPage,selectFlightPage);
    }

    @And("^total price is correct sum of all the prices$")
    public void totalPriceIsCorrectSumOfAllThePrices() {
        TourSearchAndBookPageAction.isTotalSumCorrect(bookFlightPage);
    }

    @And("^after verifying all the details customer books the flight$")
    public void afterVerifyingAllTheDetailsCustomerBooksTheFlight() {
        TourSearchAndBookPageAction.bookFlight(bookFlightPage);
        confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
    }

    @Then("^customer verifies details of confirmation page is same as review page$")
    public void customerVerifiesDetailsOfConfirmationPageIsSameAsReviewPage() {
        TourSearchAndBookPageAction.verifyDetailsOnConfirmationPage(confirmationPage, selectFlightPage);
    }

    @And("^customer prints confirmation number$")
    public void customerPrintsConfirmationNumber() {
        TourSearchAndBookPageAction.printConfirmationNumber(confirmationPage);
    }

    @And("^customer signs off$")
    public void customerSignsOff() {
        TourSearchAndBookPageAction.loggOffCustomer(confirmationPage);
    }
}
