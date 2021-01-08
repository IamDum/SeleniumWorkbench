import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeleniumServiceTest {
    private static SeleniumExample seleniumExample;


    @Test
    public void testGoogleNews() {
        seleniumExample = new SeleniumExample("https://news.google.com/topstories?hl=en-IN&gl=IN&ceid=IN:en");
        String actualTitle = seleniumExample.getTitle();
        Assert.assertNotNull(actualTitle);
        assertEquals("Google News", actualTitle);


        Actions actions = new Actions(seleniumExample.getProject().getDriver());
        List<WebElement> elements = seleniumExample.getProject().getDriver().findElements(By.className("gb_5"));

        for (WebElement element : elements) {
            String text = element.getText();
            if (text.equalsIgnoreCase("sign in")) {
                element.click();
                 //seleniumExample.closeWindow();
            }
        }
        seleniumExample = new SeleniumExample("https://accounts.google.com/signin/v2/identifier?passive=1209600&continue=https%3A%2F%2Fnews.google.com%2Ftopstories%3Fhl%3Den-IN%26gl%3DIN%26ceid%3DIN%3Aen&followup=https%3A%2F%2Fnews.google.com%2Ftopstories%3Fhl%3Den-IN%26gl%3DIN%26ceid%3DIN%3Aen&hl=en-IN&ec=GAZAqgM&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        String title = seleniumExample.getTitle();
        Assert.assertNotNull(title);
        assertEquals("Sign in – Google accounts", title);



    }
}

