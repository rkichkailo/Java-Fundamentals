package by.academy.Deal;
import java.util.regex.Pattern;

public interface Validator {

    default boolean validate (String string) {
        return getPattern().matcher(string).matches();
    }
    Pattern getPattern();

}
