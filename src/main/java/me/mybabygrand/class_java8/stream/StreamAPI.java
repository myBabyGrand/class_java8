package me.mybabygrand.class_java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    static List<OnlineClass> springClasses = null;
    static List<OnlineClass> javaClasses = null;
    static List<List<OnlineClass>> events = null;
    public static void main(String[] args) {
        makeSample();

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(s -> s.getTitle().startsWith("spring")).forEach(System.out::println);

        System.out.println("close 되지 않은 수업");
//        springClasses.stream().filter(s -> !s.isClosed()).forEach(System.out::println);
        //Using Method Reference
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(System.out::println);

        System.out.println("수업 이름만 모아서 스트림 만들기");
//        springClasses.stream().map(s->s.getTitle()).forEach(System.out::println);
        //Using Method Reference
        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
//        events.stream().flatMap(list->list.stream())
//                .forEach(System.out::println); //online class type
        //Using Method Reference
        events.stream().flatMap(Collection::stream)
                .forEach(System.out::println); //online class type


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i->i+1)
                .skip(10)//10개는 skip
                .limit(10)//10개까지
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().allMatch(s -> s.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것들의 제목만 모아서 List로 만들기");
        List<String> springTitle = springClasses.stream()
                .filter(s -> s.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        springTitle.forEach(System.out::println);


    }

    private static void makeSample() {
        springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        events = new ArrayList<>();
        events.add(springClasses);
        events.add(javaClasses);
    }
}
class OnlineClass{
    private Integer id;
    private String title;
    private boolean closed;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "OnlineClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + closed +
                '}';
    }
}
