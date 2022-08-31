package by.academy.Deal;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {

    private final Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]{2,10}+\\.[a-z]{2,6}");

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
