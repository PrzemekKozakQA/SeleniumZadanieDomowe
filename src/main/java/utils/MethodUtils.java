package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MethodUtils {
    public static boolean isWebElementDisplayed(WebElement element, Wait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("WebElement not found");
        }
        return isDisplayed;
    }

    public static void selectByText(WebElement webElement, String text) {
        Select select = new Select(webElement);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement webElement, String text) {
        Select select = new Select(webElement);
        select.selectByValue(text);
    }
}
