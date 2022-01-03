package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.awaitility.Awaitility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MethodUtils {
    public static boolean isWebElementDisplayed(WebElement element) {
        awaitUntilElementIsDisplayed(element);
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("WebElement not found");
        }
        return isDisplayed;
    }

    public static void selectByText(WebElement element, String text) {
        awaitUntilElementIsDisplayed(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String text) {
        awaitUntilElementIsDisplayed(element);
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public static void clickWhenVisible(WebElement element) {
        awaitUntilElementIsDisplayed(element);
        element.click();
    }

    public static void typeInInput(WebElement input, String string) {
        awaitUntilElementIsDisplayed(input);
        input.sendKeys(string);
    }

    public static void awaitUntilElementIsDisplayed(WebElement element) {
        Awaitility.await().atMost(10, TimeUnit.SECONDS).ignoreExceptions()
                .until(() -> (element.getSize().width > 0 && element.getSize().height > 0));
    }
}
