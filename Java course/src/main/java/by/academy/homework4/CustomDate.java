package by.academy.homework4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CustomDate {
    private LocalDate date;
    private Year year;
    private Month month;
    private Day day;
    private final LocalDate currentDay = LocalDate.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.UK);
    DateValidator validator = new DateValidator();

    public CustomDate(){
        super();
    }
    public CustomDate(String date){
        this.date = LocalDate.parse(date,formatter);
        this.year = new Year();
        this.month = new Month();
        this.day = new Day();
    }

    public void setDate(String date) {
        if(validator.validate(date)){
            this.date = LocalDate.parse(date,formatter);
        } else {
            System.out.println("Неправильный формат даты");
        }
    }

    public LocalDate getDate() {
        return date;
    }
    public int getYear(){
        return year.year;
    }
    public int getMonth(){
        return month.month;
    }
    public java.time.Month getMonthName(){
        return month.monthName;
    }
    public DayOfWeek getDayOfWeek() {
        return day.dayName;
    }
    public boolean isLeapYear(){
        return year.isLeapYear;
    }
    public long getDaysBetween(){
        long result = ChronoUnit.DAYS.between(currentDay, date);
        if(result < 0){
            return result * -1;
        } else {
            return result;
        }
    }

    private class Year{
        private final int year;
        private final boolean isLeapYear;
        private Year(){
            this.year = date.getYear();
            this.isLeapYear = date.isLeapYear();
        }
    }
    private class Month{
        private final int month;
        private final java.time.Month monthName;
        private Month(){
            this.monthName = date.getMonth();
            this.month = monthName.getValue();
        }
    }
    private class Day {
        private final int day;
        private final DayOfWeek dayName;
        private Day(){
            this.day = date.getDayOfMonth();
            this.dayName = date.getDayOfWeek();
        }
    }
}
