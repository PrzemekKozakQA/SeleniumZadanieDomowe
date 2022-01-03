package data;

import com.github.javafaker.Faker;
import enums.*;
import model.Address;
import model.User;

import java.time.Month;
import java.util.Locale;

public class TestData {
    private static Faker faker;

    private static Address getValidAddressWithAllInfo() {
        Address walidAddress = new Address();
        faker = new Faker(new Locale("en-US"));
        walidAddress.setCompany(faker.company().name());
        walidAddress.setStreet(faker.address().streetName());
        walidAddress.setAddressExtraInfo(faker.address().secondaryAddress());
        walidAddress.setCity(faker.address().city());
        walidAddress.setCountry(Country.UNITED_STATES);
        walidAddress.setState(State.ALABAMA);
        walidAddress.setZipCode(String.valueOf(faker.number().randomNumber(5, true)));
        walidAddress.setMobilePhone(faker.phoneNumber().cellPhone());
        walidAddress.setAlias("My address");
        walidAddress.setOtherInfo("My home address");
        walidAddress.setHomePhone(faker.phoneNumber().subscriberNumber());
        return walidAddress;
    }

    public static User getValidUserWithAllData() {
        faker = new Faker(new Locale("en-US"));
        User walidUser = new User();
        walidUser.setEmail(faker.internet().emailAddress());
        walidUser.setPersonalTitle(PersonalTitle.MR);
        walidUser.setFirstName(faker.name().firstName());
        walidUser.setLastName(faker.name().lastName());
        walidUser.setPassword(faker.internet().password(5, 6));
        walidUser.setDayOfBirth(DayOfBirth.D1);
        walidUser.setMonthOfBirth(Month.JANUARY);
        walidUser.setYearOfBirth(YearOfBirth.Y1994);
        walidUser.setAddress(getValidAddressWithAllInfo());
        return walidUser;
    }
}
