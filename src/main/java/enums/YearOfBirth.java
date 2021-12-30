package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum YearOfBirth {
    Y1990(1990),
    Y1991(1991),
    Y1992(1992),
    Y1993(1993),
    Y1994(1994),
    Y1995(1995),
    Y1996(1996),
    Y1997(1997),
    Y1998(1998),
    Y1999(1999),
    Y2000(2000),
    Y2001(2001),
    Y2002(2002),
    Y2003(2003),
    Y2004(2004),
    Y2005(2005),
    Y2006(2006),
    Y2007(2007),
    Y2008(2008),
    Y2009(2009),
    Y2010(2010),
    Y2011(2011),
    Y2012(2012),
    Y2013(2013),
    Y2014(2014),
    Y2015(2015),
    Y2016(2016),
    Y2017(2017),
    Y2018(2018),
    Y2019(2019),
    Y2020(2020),
    Y2021(2021);

    private int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
