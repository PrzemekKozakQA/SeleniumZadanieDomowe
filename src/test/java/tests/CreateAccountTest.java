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
    private TopMenuPage topMenuPage;
    private AuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;

    @Test
    public void shouldCreateNewUserAccountWithOnlyRequiredData() {
        //Arrange
        topMenuPage = new TopMenuPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        User allDataUser = UsersData.getValidUserWithAllData();
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        //Act
        topMenuPage.clickSignIn();
        authenticationPage.createAccountWithEmail(allDataUser.getEmail());
        createAccountPage.getPersonalInformationPage().fillInRequiredPersonalInformation(allDataUser);
        createAccountPage.getAddressPage().fillInRequiredAddressInformation(allDataUser.getAddress());
        createAccountPage.submitRegistration();
        //Assert
        Assertions.assertThat(myAccountPage.isWelcomeMessageDisplayed()).isTrue();
        //Save test data
        saveNewUserCredentialsToFile(allDataUser);
    }

    @Test
    public void shouldFillInAllData() {
        //Arrange
        topMenuPage = new TopMenuPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        User allDataUser = UsersData.getValidUserWithAllData();
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
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
        Assertions.assertThat(myAccountPage.isWelcomeMessageDisplayed()).isTrue();
        //Save test data
        saveNewUserCredentialsToFile(allDataUser);
    }
}
