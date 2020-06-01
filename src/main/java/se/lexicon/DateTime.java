package se.lexicon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateTime {

    public static void main(String[] args) {
        /*** LocalDateTime ***/
        LocalDateTime timeStamp = LocalDateTime.now();
        System.out.println(timeStamp);

        LocalDateTime next = LocalDateTime.of(2020,6,2,9,0);
        System.out.println(next);

        LocalDateTime endOfWorkWeek = LocalDateTime.parse("2020-06-05T17:00");
        System.out.println(endOfWorkWeek);

        LocalDateTime startOfNextWorkWeek = endOfWorkWeek.plusDays(2).plusHours(15);
        LocalDateTime startOfNextWorkWeek2 = endOfWorkWeek.plusMinutes(2000);
        System.out.println(startOfNextWorkWeek);
        System.out.println(startOfNextWorkWeek2);



        /*** LocalTime ***/
        LocalTime current = LocalTime.now();
        System.out.println(current);
        System.out.println(current.truncatedTo(ChronoUnit.SECONDS));
        System.out.println(current.truncatedTo(ChronoUnit.MINUTES));
        System.out.println(current.truncatedTo(ChronoUnit.HOURS));

        LocalTime noon = LocalTime.NOON;
        System.out.println(noon.plusHours(12));
        System.out.println(noon);

        LocalTime _13_39 = noon.plusHours(1).plusMinutes(39);
        System.out.println(_13_39);


        /*** LocalDate ***/
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate xmasEve = LocalDate.of(2020,12,24);
        System.out.println(xmasEve);

        LocalDate fromString = LocalDate.parse("2021-03-25");
        System.out.println(fromString);

        LocalDate firstDay = LocalDate.ofYearDay(2021,1);
        LocalDate secondDay = firstDay.plusDays(1);
        System.out.println(secondDay);

        getCal(2021).forEach(System.out::println);

    }
    public static List<LocalDate> getCal(int year){
        List<LocalDate> yearDays = new ArrayList<>();
        LocalDate firstDay = LocalDate.ofYearDay(year,1);
        LocalDate endDay = LocalDate.ofYearDay(+1,1);

        for(LocalDate date = firstDay; date.isBefore(endDay) ; date.plusDays(1)){
            yearDays.add(date);
        }
        return yearDays;
    }

}
