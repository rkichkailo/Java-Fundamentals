package by.academy.Deal;

import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator{
    Pattern pattern = Pattern.compile("^\\+375[- (.]?\\d{2}[-) .]?\\d{2,3}[- .]?\\d{2,3}[- .]?\\d{2,3}[- .]?$");

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
