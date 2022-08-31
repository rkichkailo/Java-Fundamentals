package by.academy.homework4;

import by.academy.Deal.Validator;
import java.util.regex.Pattern;

public class DateValidator implements Validator {

    private final Pattern pattern = Pattern.compile("^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[012])-(19|20)\\d\\d$");

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
