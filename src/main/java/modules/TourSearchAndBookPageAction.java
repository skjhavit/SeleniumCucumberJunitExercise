package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.BookFlightPage;
import pageObjects.ConfirmationPage;
import pageObjects.FlightFinderPage;
import pageObjects.SelectFlightPage;
import stepDefinitions.Hooks;

public class TourSearchAndBookPageAction {
    public static void isOptionDisplayed(FlightFinderPage page,String option1) {
        Assert.assertEquals(Boolean.TRUE, page.isDepartingFromOptionPresent(option1));
    }

    public static void selectSearchFlightOptions(FlightFinderPage page, String to, String from, String serviceClass) {
        page.selectArrivingToOption(Hooks.props.getProperty(to));
        page.selectDepartingFromOption(Hooks.props.getProperty(from));
        page.selectServiceClass(Hooks.props.getProperty(serviceClass));
        page.submitSearch();
    }

    public static void isSelectFlightPageLoaded(WebDriver driver) {
        Assert.assertEquals(Hooks.props.getProperty("selectFlightPageTitle"), driver.getTitle());
    }

    public static void isFlightSortedByPrice(SelectFlightPage page) {
        Assert.assertEquals(Boolean.TRUE, page.isSortedByPrice());
    }

    public static void areHeadersAligned(SelectFlightPage page) {
        Assert.assertEquals(Boolean.TRUE, page.areHeadersAlighned());
    }

    public static void doesHeaderColorMatches(SelectFlightPage page, String color) {
        Assert.assertEquals(Boolean.TRUE, page.checkHeaderColors(Hooks.props.getProperty(color)));
    }

    public static void selectSecondHeighestPrice(SelectFlightPage page) {
        page.selectSecondHeighestPrice(Integer.parseInt(Hooks.props.getProperty("priceOrder")));
        page.clickContinue();
    }
    public static void verifyAllBookingDetails(BookFlightPage bookFlightPage, SelectFlightPage selectFlightPage) {
        Assert.assertEquals(Boolean.TRUE, bookFlightPage.isInboundFlightCorrect(selectFlightPage.getInFlightNumber()));
        Assert.assertEquals(Boolean.TRUE, bookFlightPage.isOutboundFlightCorrect(selectFlightPage.getOutFlightNumber()));
    }
    public static void isTotalSumCorrect(BookFlightPage page){
        Assert.assertEquals(Boolean.TRUE, page.isTotalCorrect());
    }
    public static void bookFlight(BookFlightPage page) {
        page.bookFlight(Hooks.props);
    }

    public static void verifyDetailsOnConfirmationPage(ConfirmationPage confirmationPage, SelectFlightPage selectFlightPage) {
        Assert.assertEquals(selectFlightPage.getOutFlightNumber(), confirmationPage.getOutboundFlightName());
        Assert.assertEquals(selectFlightPage.getInFlightNumber(), confirmationPage.getInboundFlightName());
    }

    public static void printConfirmationNumber(ConfirmationPage confirmationPage) {
        System.out.println(confirmationPage.getConfirmationNumber());
    }
    public static void loggOffCustomer(ConfirmationPage confirmationPage) {
        confirmationPage.signMeOff();
    }
}
