package model;

import enums.DayOfBirth;
import enums.PersonalTitle;
import enums.YearOfBirth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.time.MonthDay;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private PersonalTitle personalTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private DayOfBirth dayOfBirth;
    private Month monthOfBirth;
    private YearOfBirth yearOfBirth;
    private Address address;
    private MonthDay monthDay;
}
