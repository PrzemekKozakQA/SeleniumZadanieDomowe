package testData;

import com.github.javafaker.Faker;
import enums.*;
import model.Address;
import model.User;

import java.time.Month;
import java.util.Locale;

public class UsersData {
    private static Faker faker;

    private static Address getValidAddressWithAllInfo() {
        Address validAddress = new Address();
        faker = new Faker(new Locale("en-US"));
        validAddress.setCompany(faker.company().name());
        validAddress.setStreet(faker.address().streetName());
        validAddress.setAddressExtraInfo(faker.address().secondaryAddress());
        validAddress.setCity(faker.address().city());
        validAddress.setCountry(Country.UNITED_STATES);
        validAddress.setState(State.ALABAMA);
        validAddress.setZipCode(String.valueOf(faker.number().randomNumber(5, true)));
        validAddress.setMobilePhone(faker.phoneNumber().cellPhone());
        validAddress.setAlias("My address");
        validAddress.setOtherInfo("My home address");
        validAddress.setHomePhone(faker.phoneNumber().subscriberNumber());
        return validAddress;
    }

    public static User getValidUserWithAllData() {
        faker = new Faker(new Locale("en-US"));
        User validUser = new User();
        validUser.setEmail(faker.internet().emailAddress());
        validUser.setPersonalTitle(PersonalTitle.MR);
        validUser.setFirstName(faker.name().firstName());
        validUser.setLastName(faker.name().lastName());
        validUser.setPassword(faker.internet().password(5, 6));
        validUser.setDayOfBirth(DayOfBirth.D1);
        validUser.setMonthOfBirth(Month.JANUARY);
        validUser.setYearOfBirth(YearOfBirth.Y1994);
        validUser.setAddress(getValidAddressWithAllInfo());
        return validUser;
    }
}
