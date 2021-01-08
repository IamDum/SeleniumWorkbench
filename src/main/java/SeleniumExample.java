import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class SeleniumExample {

    private SeleniumProject project;


    public SeleniumExample(String url) {
        project = new SeleniumProject();
        project.getDriver().get(url);
    }
    public void closeWindow() {
        this.project.getDriver().close();
    }

    public String getTitle() {
        return this.project.getDriver().getTitle();
    }
    private void clickAboutLink() {
        Actions actions = new Actions(project.getDriver());
        WebElement aboutElement = this.project.getDriver()
                .findElement(By.id("menu-item-6138"));

        actions.moveToElement(aboutElement).perform();
    }
    public SeleniumProject getProject() {
        return project;
    }

}


