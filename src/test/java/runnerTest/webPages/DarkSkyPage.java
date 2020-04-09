package runnerTest.webPages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DarkSkyPage extends ElementUtil {


    private By searchBox= By.xpath("//input[@type='text']");

    private By searchBtn= By.className("searchButton");
    private By hours= By.xpath("//div[@class='scroll-container']//span[@class='hour']");
    private By plusBtn= By.xpath("(//span[@class='open'])[1]");
    private By temp= By.xpath("//div[@class='dayDetails revealed']//span[contains(@style,'opacity')]");
    private By minTop = By.xpath("//span[@class='low-temp-text']");
    private By maxTop = By.xpath("//span[@class='high-temp-text']");
    private By minTemp=By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    private By maxTemp=By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    public String getDarkSkyPageTitle() throws InterruptedException {
        Thread.sleep(1000);
        return BasePage.get().getTitle();
    }

    public void sendTextToSearchField(String locationValue) throws InterruptedException {
        clear(searchBox);
        sendValue(searchBox, locationValue);
        clickOn(searchBtn);
    }

    public List<Integer> getTimeline(){
        List<WebElement>hour= webElements(hours);
        List<Integer>time=new ArrayList<Integer>();
        for(WebElement e:hour){
            String t= e.getText();
            if(!t.isEmpty()){
                int th=Integer.parseInt(t.replaceAll("[a-z]", ""));
                time.add(th);}
        }
        return time;
    }

    public boolean verifyHourFormat(String zone){
        ZoneId timezone = ZoneId.of(zone);
        int hour  = LocalTime.now(timezone).getHour();
        List<Integer> time=new ArrayList<>();
        for(int i=0; i<getTimeline().size(); i++){
            if(hour<11) hour+=2;
            else  hour-=10;
            time.add(hour);
        }

        return time.equals(getTimeline());
    }

    public void expandToday(){
        scrollByPixel("0", "1000");
        clickElementByJS(plusBtn);
    }

    public List<Integer> getTimeLineTemps() throws InterruptedException {
        List<WebElement> temps= webElements(temp);
        Thread.sleep(1000);
        List<Integer> tempInt = new ArrayList<Integer>();
        Thread.sleep(1000);
        for(WebElement e: temps){
            int t= Integer.parseInt(e.getText().replaceAll("[^0-9]",""));
            tempInt.add(t);
        }
        return tempInt;
    }

    public int findMax(List<Integer> list) {
        int max=list.get(0);
        for(int i: list)
            if(i>max){
                max=i;
            }
        return max;
    }

    public int findMin(List<Integer> list) {
        int min=list.get(0);
        for(int i: list)
            if(i<min){
                min=i;
            }
        return min;
    }
    public boolean verifyLowestTemp() throws InterruptedException {
        int lowTemp= Integer.parseInt(getTextFromElement(minTemp).replaceAll("[^0-9]",""));
        return findMin(getTimeLineTemps())==lowTemp;
    }

    public boolean verifyHighestTemp() throws InterruptedException {
        int highTemp= Integer.parseInt(getTextFromElement(maxTemp).replaceAll("[^0-9]",""));
        Thread.sleep(1000);
        return findMax(getTimeLineTemps())==highTemp;
    }

    public boolean verifyLowTemp() throws InterruptedException {
        String temp1= getTextFromElement(minTop);
        Thread.sleep(1000);
        String temp2= getTextFromElement(minTemp);
        Thread.sleep(1000);
        return temp1.equals(temp2);
    }
    public boolean verifyHighTemp() throws InterruptedException {
        String temp1= getTextFromElement(maxTop);
        Thread.sleep(1000);
        String temp2= getTextFromElement(maxTemp);
        Thread.sleep(1000);
        return temp1.equals(temp2);
    }
}
