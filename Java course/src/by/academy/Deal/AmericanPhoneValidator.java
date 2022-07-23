package by.academy.Deal;

import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {

    private final Pattern pattern = Pattern.compile("^\\+1[- (.]?\\d{3}[-) .]?\\d{3}[- .]?\\d{4}[- .]?$");

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
