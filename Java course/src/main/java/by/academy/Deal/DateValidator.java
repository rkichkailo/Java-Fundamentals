package by.academy.Deal;

import java.util.regex.Pattern;

public interface DateValidator {
    default boolean dateValid (String string, int n)  {
        if (n == 1) {
            return getPattern1().matcher(string).matches();
        } else {
            return getPattern2().matcher(string).matches();
        }
    }

    Pattern getPattern1();
    Pattern getPattern2();
}
