package pages;

import enums.DayOfBirth;
import enums.PersonalTitle;
import enums.YearOfBirth;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MethodUtils;

import java.time.Month;

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
        wait.until(ExpectedConditions.visibilityOf(mrsTitleMark));
        if (title.equals(PersonalTitle.MR)) {
            mrTitleMark.click();
        } else {
            mrsTitleMark.click();
        }
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void selectDayOfBirth(DayOfBirth day) {
        MethodUtils.selectByValue(dayOfBirthSelect, day.toString());
    }

    public void selectMonthOfBirth(Month month) {
        MethodUtils.selectByValue(monthOfBirthSelect, String.valueOf(month.getValue()));
    }

    public void selectYearOfBirth(YearOfBirth year) {
        MethodUtils.selectByValue(yearOfBirthSelect, year.toString());
    }

    public void markNewsletter() {
        newsletterCheckbox.click();
    }

    public void markSpecialOffers() {
        specialOffersCheckbox.click();
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
