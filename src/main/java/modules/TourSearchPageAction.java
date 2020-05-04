package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.FlightFinderPage;
import stepDefinitions.Hooks;

public class TourSearchPageAction {
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
        org.junit.Assert.assertEquals(Hooks.props.getProperty("selectFlightPageTitle"), driver.getTitle());
    }

}
