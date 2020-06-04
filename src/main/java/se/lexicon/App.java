package se.lexicon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

/**
 * Date Time examples
 */
public class App 
{
    public static void main( String[] args )
    {
        ex1();
    }
    public static void ex1(){
        // Create a LocalDate of the current day and print it out
        System.out.println(LocalDate.now());
    }
    public static void ex2(){
      //  Create a LocalDate of the current day and print it out in the following
      //  pattern using DateTimeFormatter: Torsdag 29 mars.
        LocalDate date = LocalDate.parse("2020-03-29");
        String print = date.format(DateTimeFormatter.ofPattern("eeee dd MMMM"));
        System.out.println(print);
    }
    public static void ex3(){
        //Create a LocalDate of last Monday. Then print out the entire week in a loop using standard ISO format.
        LocalDate date1 = LocalDate.parse("2020-05-25");
        LocalDate date2 = LocalDate.parse("2020-06-01");
        String print = date1.format(DateTimeFormatter.BASIC_ISO_DATE);

        for(LocalDate date = date1; date.isBefore(date2); date = date.plusDays(1)) {
            System.out.println(print);
        }

    }
    public static void ex4(){
        //Create a LocalDate object from a String by using the .parse() method
        LocalDate date = LocalDate.parse("2020-06-01");
        System.out.println(date);

        String date2 = "2020-06-01";
        System.out.println(LocalDate.parse(date2));
    }
    public static void ex5(){
        // The date time api provides enums for time units such as day and month.
        // Create a LocalDate of 1945-05-08 and extract the day of week for that date.
        LocalDate date = LocalDate.parse("1945-05-08");
        System.out.println(date.getDayOfWeek());

    }
    public static void ex6(){
        // Create a LocalDate of current date plus 10 years and minus 10 months.
        // From that date extract the month and print it out.
        LocalDate date = LocalDate.now();
        System.out.println(date.plusYears(10).minusMonths(10).getMonth());
        System.out.println(date.plusYears(10).minusMonths(10).getDayOfWeek());
        System.out.println(date.plusYears(10).minusMonths(10).getYear());
        System.out.println(date.plusYears(10).minusMonths(10));


    }
    public static void ex7(){
        // Using the LocalDate from exercise 6 and your birthdate, create a Period
        // between your birthdate and the date from exercise 5. Print out the elapsed years, months and days.
        LocalDate date0 = LocalDate.parse("1982-04-13");
        LocalDate date1 = LocalDate.parse("1945-05-08");
        LocalDate date2 = date0.plusYears(10).minusMonths(10);

        Period period = Period.between(date1,date2);
        int year = period.getYears();
        int month = period.getMonths();
        int day = period.getDays();

        System.out.println("Years: "+year+" Months: "+month+" Days: "+day);

    }
    public static void ex8(){
        // Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of current
        // date and add the period you created to the current date.
        Period period = Period.of(4,7,29);
        LocalDate date = LocalDate.now();

        LocalDate result = date.plus(period);
        System.out.println(result);
    }
    public static void ex9(){
        // Create a LocalTime object of the current time.
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }
    public static void ex10(){
        //Extract the nanoseconds of a LocalTime object of current time. Print out the nanoseconds.
        LocalTime time = LocalTime.now();
        System.out.println(time.getNano());
    }
    public static void ex11(){
        // Create a LocalTime object from a String using the .parse() method.
        String date0 = "12:00";
        LocalTime date1 = LocalTime.parse(date0);
        System.out.println(date1);
    }
    public static void ex12(){
        // Using DateTimeFormatter format LocalTime from current time and print it out as following pattern:
        // 10:32:53
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(LocalTime.now().format(format));
    }
    public static void ex13(){
        // Create a LocalDateTime with the date and time components as: date: 2018-04-05, time: 10.00.
        DateTimeFormatter format0 = DateTimeFormatter.ofPattern("YYYY-MM-dd 'T' HH:mm");
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println(LocalDateTime.now().format(format0));

        System.out.println("Date: "+LocalDateTime.now().format(format2)+" Time: "+LocalDateTime.now().format(format1));
    }
    public static void ex14(){
        // Using DateTimeFormatter format the LocalDateTime object from exercise 11 to a
        // String that should look tile this: torsdag 5 april 10:00
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE dd MMMM HH:mm");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        /** ALT 1 **/
        String dateTime = "2020-01-01 08:00";
        LocalDateTime toString2 = LocalDateTime.parse(dateTime, format2);
        String toString3 = toString2.format(format);
        System.out.println(toString3);


        /** ALT 2 **/
        LocalDateTime date = LocalDateTime.now();
        String toString = date.format(format);
        System.out.println(toString);

    }
    public static void ex15(){
        // Create a LocalDateTime object by combining LocalDate object and LocalTime object.
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        /** ALT 1 **/
        System.out.println(dateTime);

        /** ALT 2 **/
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        String toString = dateTime.format(format);
        System.out.println(toString);

    }
    public static void ex16(){
        // Create a LocalDateTime object. Then get the LocalDate and LocalTime components
        // into separate objects of respective types from the LocalDateTime object.
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();

        System.out.println("LocalDateTime: "+dateTime);
        System.out.println("LocalDate: "+date);
        System.out.println("LocalTime: "+time.getHour()+":"+time.getMinute()+":"+time.getSecond());
    }
}
