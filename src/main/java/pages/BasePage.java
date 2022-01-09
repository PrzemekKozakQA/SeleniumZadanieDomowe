package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public abstract class BasePage {
    FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new FluentWait<>(driver);

    }
}
