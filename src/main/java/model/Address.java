package model;

import enums.Country;
import enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String company;
    private String street;
    private String addressExtraInfo;
    private String city;
    private State state;
    private String zipCode;
    private Country country;
    private String homePhone;
    private String mobilePhone;
    private String alias;
    private String otherInfo;

}
