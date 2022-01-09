package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.User;
import org.awaitility.Awaitility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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

    public static void awaitUntilElementIsDisplayed(WebElement element) {
        Awaitility.await().atMost(10, TimeUnit.SECONDS).ignoreExceptions()
                .until(() -> (element.getSize().width > 0 && element.getSize().height > 0));
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

    public static void clickWhenAvailable(WebElement element) {
        awaitUntilElementIsDisplayed(element);
        element.click();
    }

    public static void typeInInput(WebElement input, String string) {
        awaitUntilElementIsDisplayed(input);
        input.sendKeys(string);
    }

    public static String getActualDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    public static void saveNewUserCredentialsToFile(User user) {
        try {
            PrintWriter writer = new PrintWriter("outputTestFiles/test_user_credentials " + getActualDateAndTime() + ".txt");
            writer.println("Login=" + user.getEmail());
            writer.println("Password=" + user.getPassword());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
