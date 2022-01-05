package tests;

import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.MyAccountPage;
import pages.TopMenuPage;
import testData.UsersData;

import static utils.MethodUtils.saveNewUserCredentialsToFile;

public class CreateAccountTest extends BaseTest {
    @Test
    public void shouldCreateNewUserAccountWithOnlyRequiredData() {
        //Arrange
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        User allDataUser = UsersData.getValidUserWithAllData();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        //Act
        topMenuPage.clickSignIn();
        authenticationPage.createAccountWithEmail(allDataUser.getEmail());
        createAccountPage.getPersonalInformationPage().fillInRequiredPersonalInformation(allDataUser);
        createAccountPage.getAddressPage().fillInRequiredAddressInformation(allDataUser.getAddress());
        createAccountPage.submitRegistration();
        //Assert
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assertions.assertThat(myAccountPage.isWelcomeMessageDisplayed()).isTrue();
        //Save test data
        saveNewUserCredentialsToFile(allDataUser);
    }

    @Test
    public void shouldFillInAllData() {
        //Arrange
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        User allDataUser = UsersData.getValidUserWithAllData();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        //Act
        topMenuPage.clickSignIn();
        authenticationPage.createAccountWithEmail(allDataUser.getEmail());
        createAccountPage.getPersonalInformationPage().fillInRequiredPersonalInformation(allDataUser);
        createAccountPage.getPersonalInformationPage().fillInNotRequiredPersonalInformation(allDataUser);
        createAccountPage.getPersonalInformationPage().markNewsletter();
        createAccountPage.getPersonalInformationPage().markSpecialOffers();
        createAccountPage.getAddressPage().fillInRequiredAddressInformation(allDataUser.getAddress());
        createAccountPage.getAddressPage().fillInNotRequiredAddressInformation(allDataUser.getAddress());
        createAccountPage.submitRegistration();
        //Assert
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assertions.assertThat(myAccountPage.isWelcomeMessageDisplayed()).isTrue();
        //Save test data
        saveNewUserCredentialsToFile(allDataUser);
    }
}
