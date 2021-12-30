package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Country {
    UNITED_STATES("United States");

    private String value;
}
