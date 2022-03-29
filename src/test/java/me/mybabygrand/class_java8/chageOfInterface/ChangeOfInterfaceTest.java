package me.mybabygrand.class_java8.chageOfInterface;

import me.mybabygrand.class_java8.changeOfInterface.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ChangeOfInterfaceTest {

    @Test
    void defaultInterfaceTest(){
        DefaultMethodInterface defaultMethodInterface1 = new DefaultMethodInterfaceImpl1();
        DefaultMethodInterface defaultMethodInterface2 = new DefaultInterfaceImpl2();

        defaultMethodInterface1.printClassName();
        defaultMethodInterface2.printClassName();

        defaultMethodInterface1.printUpperClassName();
        defaultMethodInterface2.printUpperClassName();

    }

    @Test
    void defaultInterface2Test(){
        DefaultMethodInterface2 defaultMethodInterface2 = new DefaultMethodInterface2Impl();
        defaultMethodInterface2.printClassName();
        defaultMethodInterface2.printUpperClassName();
    }

    @Test
    void staticMethodInterfaceTest(){
        StaticMethodInterface staticMethodInterface = new StaticMethodInterfaceImpl();
        StaticMethodInterface.printAnything();
    }

    @Test
    void defaultMethodInIterable(){
        List<String> name = new ArrayList<>();
        name.add("AA");
        name.add("BB");
        name.add("CC");
        name.add("DD");

        name.forEach(System.out::println);

        System.out.println("===== iterable() =====");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator1.tryAdvance(System.out::println));
        while(spliterator.tryAdvance(System.out::println));
    }

    @Test
    void defaultMethodCollection(){
        List<String> name = new ArrayList<>();
        name.add("My");
        name.add("Baby");
        name.add("Grand");

        System.out.println("===== steam() =====");
        Set<String> name2 = name.stream().map(String::toUpperCase).filter(s->s.startsWith("B")).collect(Collectors.toSet());
        name2.forEach(System.out::println);

        System.out.println("===== removeIf() =====");
        name.removeIf(s->s.startsWith("B"));
        name.forEach(System.out::println);
    }

    @Test
    void defaultAndStaticMethodComparator(){
        List<String> name = new ArrayList<>();
        name.add("D");
        name.add("CC");
        name.add("BBB");
        name.add("AAAA");


        System.out.println("===== reversed() =====");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);

        name.clear();
        name.add("BB");
        name.add("DD");
        name.add("AA");
        name.add("CC");
        System.out.println("===== thenComparing() =====");
        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
        name.sort(stringLengthComparator);
        name.forEach(System.out::println);//길이가 같다면 입력된 순서대로 출력된다.
        System.out.println("===== thenComparing(String.CASE_INSENSITIVE_ORDER) =====");
        name.sort(stringLengthComparator.thenComparing(String.CASE_INSENSITIVE_ORDER));
        name.forEach(System.out::println);//알파벳 순서대로

        System.out.println("===== Comparator.reverseOrder()) =====");
        name.sort((Comparator.reverseOrder()));
        name.forEach(System.out::println);

        System.out.println("===== Comparator.naturalOrder()) =====");
        name.sort((Comparator.naturalOrder()));
        name.forEach(System.out::println);

        name.add(null);
        System.out.println("===== Comparator.nullsFirst())=====");
        name.sort(Comparator.nullsFirst(stringLengthComparator));
        name.forEach(System.out::println);
        System.out.println("===== Comparator.nullsLast() =====");
        name.sort(Comparator.nullsLast(stringLengthComparator));
        name.forEach(System.out::println);
        
        System.out.println("===== Comparator.comparing Age =====");
        List<Person> fullNames = new ArrayList<>();
        fullNames.add(new Person(37, "Bruce Wayne"));
        fullNames.add(new Person(17, "Peter Parker"));
        fullNames.add(new Person(37, "Tony Stark"));
        fullNames.add(new Person(88, "Steve Rogers"));
        Comparator<Person> comparingAge = Comparator.comparing(Person::getAge);
        fullNames.sort(comparingAge);
        fullNames.forEach(System.out::println);
        System.out.println("===== Comparator.comparing Name=====");
        Comparator<Person> comparingName = Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER);
        fullNames.sort(comparingName);
        fullNames.forEach(System.out::println);

    }


    static class Person{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name= name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
