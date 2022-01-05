package tests;

import data.TestData;
import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.*;

public class CreateAccountTest extends BaseTesty {
    @Test
    public void shouldCreateNewUserAccountWithRequiredAndNorRequiredData() {
        //SignIn
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickSignIn();
        //Create new account
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        User allDataUser = TestData.getValidUserWithAllData();
        authenticationPage.createAccountWithEmail(allDataUser.getEmail());
        //Fill all personal information
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.chosePersonalTitle(allDataUser.getPersonalTitle());
        personalInformationPage.fillInRequiredPersonalInformation(allDataUser);

        //Mark agreements
//        personalInformationPage.markNewsletter();
//        personalInformationPage.markSpecialOffers();
        //Fill all address information
        AddressPage addressPage = new AddressPage(driver);
//        addressPage.fillInRequiredAddressInformation(allDataUser.getAddress());
////        addressPage.fillInNotRequiredAddressInformation(allDataUser.getAddress());
//        //Submit creating account
//        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
//        createAccountPage.submitRegistration();
//        //Check that account was created
//        MyAccountPage myAccountPage = new MyAccountPage(driver);
//        Assertions.assertThat(myAccountPage.isWelcomeMessageDisplayed()).isTrue();
    }

}
