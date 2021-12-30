package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonalTitle {
    MR("Mr."), MRS("Mrs.");

    private String value;
}
