package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.User;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MethodUtils {
    public static boolean isWebElementDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("WebElement not found");
        }
        return isDisplayed;
    }

    public static void waitUntilElementIsDisplayed(WebElement element, FluentWait<WebDriver> wait) {
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until((ExpectedCondition<Boolean>) (webDriver) -> element.getSize().width > 0);
    }

    public static void selectByText(WebElement element, String text, FluentWait<WebDriver> wait) {
        waitUntilElementIsDisplayed(element, wait);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String text, FluentWait<WebDriver> wait) {
        waitUntilElementIsDisplayed(element, wait);
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public static void clickWhenAvailable(WebElement element, FluentWait<WebDriver> wait) {
        waitUntilElementIsDisplayed(element, wait);
        element.click();
    }

    public static void typeInInput(WebElement input, String string, FluentWait<WebDriver> wait) {
        waitUntilElementIsDisplayed(input, wait);
        input.sendKeys(string);
    }

    public static String getActualDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    public static void saveNewUserCredentialsToFile(User user) {
        try {
            PrintWriter writer = new PrintWriter("outputTestFiles/test_user_credentials "
                    + getActualDateAndTime() + ".properties");
            writer.println("Login=" + user.getEmail());
            writer.println("Password=" + user.getPassword());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
