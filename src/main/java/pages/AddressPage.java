package pages;

import enums.Country;
import enums.State;
import model.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.MethodUtils.selectByText;
import static utils.MethodUtils.typeInInput;

public class AddressPage extends BasePage {
    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement addressInput;

    @FindBy(id = "address2")
    WebElement addressSecondLineInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(name = "id_state")
    WebElement stateSelect;

    @FindBy(id = "postcode")
    WebElement zipCodeInput;

    @FindBy(id = "id_country")
    WebElement countrySelect;

    @FindBy(id = "other")
    WebElement otherInfoInput;

    @FindBy(id = "phone")
    WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    WebElement aliasInput;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public void enterCompany(String company) {
        typeInInput(companyInput, company, wait);
    }

    public void enterAddress(String address) {
        typeInInput(addressInput, address, wait);
    }

    public void enterAddressSecondLine(String address2) {
        typeInInput(addressSecondLineInput, address2, wait);
    }

    public void enterCity(String city) {
        typeInInput(cityInput, city, wait);
    }

    public void selectState(State state) {
        selectByText(stateSelect, state.getValue(), wait);
    }

    public void enterZipCode(String zipCode) {
        typeInInput(zipCodeInput, zipCode, wait);
    }

    public void selectCountry(Country country) {
        selectByText(countrySelect, country.getValue(), wait);
    }

    public void enterOtherInfo(String otherInfo) {
        typeInInput(otherInfoInput, otherInfo, wait);
    }

    public void enterMobilePhone(String mobile) {
        typeInInput(mobilePhoneInput, mobile, wait);
    }

    public void enterHomePhone(String phone) {
        typeInInput(homePhoneInput, phone, wait);
    }

    public void enterAlias(String alias) {
        typeInInput(aliasInput, alias, wait);
    }

    public void fillInRequiredAddressInformation(Address address) {
        enterAddress(address.getStreet());
        enterCity(address.getCity());
        selectState(address.getState());
        enterZipCode(address.getZipCode());
        selectCountry(address.getCountry());
        enterMobilePhone(address.getMobilePhone());
    }

    public void fillInNotRequiredAddressInformation(Address address) {
        enterCompany(address.getCompany());
        enterAddressSecondLine(address.getAddressExtraInfo());
        enterOtherInfo(address.getOtherInfo());
        enterHomePhone(address.getHomePhone());
        enterAlias(address.getAlias());
    }
}
