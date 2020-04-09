package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import runnerTest.webPages.DarkSkyPage;


public class DarkSkyPageSD {

    private DarkSkyPage darkSkyPage = new DarkSkyPage();

    @Given("^I am on DarkSkyPage$")
    public void verifyHomePage() throws InterruptedException {
        Assert.assertEquals(darkSkyPage.getDarkSkyPageTitle(), "Dark Sky - Broadway, New York, NY");
    }

    @When ("^I entered (.+) in search box$")
    public void verifyChosenLocationPage(String location) throws InterruptedException {
        darkSkyPage.sendTextToSearchField(location);

        Assert.assertEquals(darkSkyPage.getDarkSkyPageTitle(), "Dark Sky - South Lafayette Avenue, Chicago, IL");

    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline() throws InterruptedException {

        Assert.assertTrue(darkSkyPage.verifyHourFormat("America/Chicago"), "Hours not displayed correctly");
    }
    @When("^I expand today's timeline$")
    public void expandToday(){
        darkSkyPage.expandToday();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTempValues() throws InterruptedException {
        Assert.assertTrue(darkSkyPage.verifyLowTemp(), "Lowest Temperature is not matching");
        Assert.assertTrue(darkSkyPage.verifyHighTemp(), "Highest Temperature is not matching");
    }

}


