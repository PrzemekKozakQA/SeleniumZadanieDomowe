package pages;

import enums.DayOfBirth;
import enums.PersonalTitle;
import enums.YearOfBirth;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Month;

import static utils.MethodUtils.*;

public class PersonalInformationPage extends BasePage {
    @FindBy(id = "id_gender1")
    WebElement mrTitleMark;

    @FindBy(id = "id_gender2")
    WebElement mrsTitleMark;

    @FindBy(id = "customer_firstname")
    WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    WebElement lastNameInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "days")
    WebElement dayOfBirthSelect;

    @FindBy(id = "months")
    WebElement monthOfBirthSelect;

    @FindBy(id = "years")
    WebElement yearOfBirthSelect;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOffersCheckbox;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void chosePersonalTitle(PersonalTitle title) {
        waitUntilElementIsDisplayed(mrsTitleMark, wait);
        if (title.equals(PersonalTitle.MR)) {
            mrTitleMark.click();
        } else {
            mrsTitleMark.click();
        }
    }

    public void enterFirstName(String firstName) {
        waitUntilElementIsDisplayed(firstNameInput, wait);
        typeInInput(firstNameInput, firstName, wait);
    }

    public void enterLastName(String lastName) {
        typeInInput(lastNameInput, lastName, wait);
    }

    public void enterPassword(String password) {
        typeInInput(passwordInput, password, wait);
    }

    public void selectDayOfBirth(DayOfBirth day) {
        selectByValue(dayOfBirthSelect, day.toString(), wait);
    }

    public void selectMonthOfBirth(Month month) {
        selectByValue(monthOfBirthSelect, String.valueOf(month.getValue()), wait);
    }

    public void selectYearOfBirth(YearOfBirth year) {
        selectByValue(yearOfBirthSelect, year.toString(), wait);
    }

    public void markNewsletter() {
        clickWhenAvailable(newsletterCheckbox, wait);
    }

    public void markSpecialOffers() {
        clickWhenAvailable(specialOffersCheckbox, wait);
    }

    public void fillInRequiredPersonalInformation(User user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterPassword(user.getPassword());
    }

    public void fillInNotRequiredPersonalInformation(User user) {
        chosePersonalTitle(user.getPersonalTitle());
        selectDayOfBirth(user.getDayOfBirth());
        selectMonthOfBirth(user.getMonthOfBirth());
        selectYearOfBirth(user.getYearOfBirth());
    }
}
