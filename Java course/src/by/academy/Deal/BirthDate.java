package by.academy.Deal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

public class BirthDate implements DateValidator{
    private final Pattern pattern1 = Pattern.compile("^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$");
    private final Pattern pattern2 = Pattern.compile("^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[012])-(19|20)\\d\\d$");

    private DateTimeFormatter formatter;
    private LocalDate date;
    @Override
    public Pattern getPattern1() {
        return pattern1;
    }
    @Override
    public Pattern getPattern2(){
        return pattern2;
    }

    public boolean dateCheck(String dateOfBirth){

        if (dateValid(dateOfBirth, 1)){
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.UK);
            date = LocalDate.parse(dateOfBirth, formatter);
            dateInfo();
            return true;
        } else if (dateValid(dateOfBirth, 2)){
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.UK);
            date = LocalDate.parse(dateOfBirth, formatter);
            dateInfo();
            return true;
        } else {
            System.out.println("Неправильный формат даты \n------------------------------------------------------");
            return false;
        }
    }
    public void dateInfo(){
        System.out.println( "Day: " + date.getDayOfMonth() +
                "\nMonth: " + date.getMonth() +
                "\nYear: " + date.getYear() +
                "\n------------------------------------------------------");
    }
    public LocalDate getDateBirth(){
        return date;
    }

}
