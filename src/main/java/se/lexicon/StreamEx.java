package se.lexicon;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {

    public static void main(String[] args) {
        ex3();
    }

    public static People[] list(){
        List<People> arrayList = Arrays.asList(
                new People("Name1","LastName1", LocalDate.parse("2020-01-01")),
                new People("Name2", "Andersson", LocalDate.parse("2020-01-02")),
                new People("Name3", "Andersson", LocalDate.parse("2020-01-03")),
                new People("Name4", "Andersson", LocalDate.parse("2020-01-04")),
                new People("Name5", "LastName5", LocalDate.parse("2020-01-05"))
        );
        People[] array = new People[arrayList.size()];
        arrayList.toArray(array);
        return array;
    }

    public static void ex1(){
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Write code here
        Stream.of(integers).forEach(System.out::println);
    }
    public static void ex2(){
        long amount = 0;

        //Write code here
        Stream<People> counting = Stream.of(list());
        long a = counting.count();
        System.out.println(a);

    }
    public static void ex3(){
        long amount = 0;
        int expected = 90;

        //Write code here
        System.out.println(Stream.of(list()).filter(People -> People.getLastName()
                .equalsIgnoreCase("Andersson")).count());

    }

}
