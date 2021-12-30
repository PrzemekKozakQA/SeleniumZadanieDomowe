package pages;

import enums.Country;
import enums.State;
import model.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.MethodUtils;

public class AddressPage extends BasePage {
    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement addressInput;

    @FindBy(id = "address2")
    WebElement addressSecondLineInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "id_state")
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
        companyInput.sendKeys(company);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterAddressSecondLine(String address2) {
        addressSecondLineInput.sendKeys(address2);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void selectState(State state) {
        MethodUtils.selectByText(stateSelect, state.getValue());
    }

    public void enterZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void selectCountry(Country country) {
        MethodUtils.selectByText(countrySelect, country.getValue());
    }

    public void enterOtherInfo(String otherInfo) {
        otherInfoInput.sendKeys(otherInfo);
    }

    public void enterMobilePhone(String mobile) {
        mobilePhoneInput.sendKeys(mobile);
    }

    public void enterHomePhone(String phone) {
        homePhoneInput.sendKeys(phone);
    }

    public void enterAlias(String alias) {
        aliasInput.sendKeys(alias);
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
