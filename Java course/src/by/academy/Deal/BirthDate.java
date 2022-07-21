package by.academy.Deal;

import java.util.regex.Pattern;

public class BirthDate implements DateValidator{
    Pattern pattern1 = Pattern.compile("^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$");
    Pattern pattern2 = Pattern.compile("^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[012])-(19|20)\\d\\d$");
    @Override
    public Pattern getPattern1() {
        return pattern1;
    }
    @Override
    public Pattern getPattern2(){
        return pattern2;
    }

}
