package modules;

import org.testng.Assert;
import pageObjects.FlightFinderPage;
import pageObjects.ToursHomePage;
import pageObjects.ToursSignOnPage;
import stepDefinitions.Hooks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TourHomePageAction {
public static void isCurrentDateDisplayed(ToursHomePage homePage) {
    String currentDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(LocalDateTime.now());
    Assert.assertEquals(currentDate, homePage.getCurrentDate());
}

    public static void isImageDisplayed(ToursHomePage homePage, String imageName) {
        Assert.assertEquals(imageName, homePage.getFeaturedDestination().split(":")[1].trim());
    }

    public static void performLoginOperation(ToursHomePage homePage, String userName, String password) {
        homePage.typeUserName(Hooks.props.getProperty(userName));
        homePage.typePassword(Hooks.props.getProperty(password));
        homePage.submitForm();
    }

    public static void isSignOnPageLoaded(ToursSignOnPage signOnPage) {
        Boolean condition = signOnPage.getSignOnImage().equalsIgnoreCase(Hooks.props.getProperty("sectionImageURL")) && signOnPage.getSignOnSectionText().trim().equalsIgnoreCase(Hooks.props.getProperty("sectionText"));
        Assert.assertEquals(Boolean.TRUE,condition);
    }

    public static void isSearchFlightPageLoaded(FlightFinderPage page) {
        org.junit.Assert.assertEquals(Hooks.props.getProperty("finderImageURL"), page.getFinderImageURL());
        org.junit.Assert.assertEquals(Hooks.props.getProperty("flightPageURL"), Hooks.driver.getCurrentUrl().split("\\?")[0].trim());

    }
}
