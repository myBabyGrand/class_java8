package me.mybabygrand.class_java8.optional;

import me.mybabygrand.class_java8.OnlineClass;
import me.mybabygrand.class_java8.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalAPI {
    static List<OnlineClass> springClasses = null;
    public static void main(String[] args) {
        springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        //값이 있는 optional
        Optional<OnlineClass> spring = springClasses.stream()
                .filter(p -> p.getTitle().startsWith("spring"))
                .findFirst();

        //값이 없는 optional
        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(p -> p.getTitle().startsWith("jpa"))
                .findFirst();

        //Optional에 값이 있는지 없는지 확인하기
        System.out.println("=====isPresent(), isEmpty()=====");
        System.out.println(spring.isPresent());
        System.out.println(spring.isEmpty());
        System.out.println(jpa.isPresent());
        System.out.println(jpa.isEmpty());

        System.out.println("=====get()=====");
        //값 가져오기
        System.out.println(spring.get().getTitle());

        //값이 없는 경우
        //System.out.println(jpa.get()); //NoSuchElementException

        System.out.println("=====ifPresent=====");
        // Optional에 값이 있는 경우에 그 값을 가지고 ~~를 하라.
        spring.ifPresent(oc -> System.out.println(oc.getTitle()));

        System.out.println("=====orElse=====");
        // Optional에 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라.
        OnlineClass onlineClass1 = spring.orElse(createDummyClass());
        System.out.println(onlineClass1);
        OnlineClass onlineClass2 = jpa.orElse(createDummyClass());
        System.out.println(onlineClass2);

        System.out.println("=====orElseGet=====");
        // Optional에 값이 있으면 가져오고 없는 경우에 ~~를 하라.
        OnlineClass onlineClass3 = spring.orElseGet(OptionalAPI::createDummyClass);
        System.out.println(onlineClass3);
        OnlineClass onlineClass4 = jpa.orElseGet(OptionalAPI::createDummyClass);
        System.out.println(onlineClass4);

        System.out.println("=====filter=====");
        // Optional에 들어있는 값 걸러내기
        Optional<OnlineClass> onlineClass5 = spring.filter(oc -> oc.getId() > 1000);
        System.out.println(onlineClass5.isPresent());
        Optional<OnlineClass> onlineClass6 = spring.filter(oc -> oc.getId() < 1000);
        System.out.println(onlineClass6.isPresent());

        System.out.println("=====map=====");
        // Optional에 들어있는 값 변환하기
        Optional<Integer> integer = spring.map(OnlineClass::getId);
        System.out.println(integer.isPresent());
        System.out.println("=====flatMap=====");
//        Optional<Optional<Progress>> progress1 = spring.map(OnlineClass::getProgress);
//        Optional<Progress> progress2 = progress1.orElseThrow();
//        System.out.println(progress2.isPresent());
        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);
        System.out.println(progress.isPresent());

        System.out.println("=====orElseThrow=====");
        // Optional에 값이 있으면 가져오고 없는 경우 에러를 던져라.
        OnlineClass onlineClass9 = spring.orElseThrow();
        System.out.println(onlineClass9);
        OnlineClass onlineClass10 = jpa.orElseThrow(IllegalArgumentException::new);
        System.out.println(onlineClass10);
    }

    private static OnlineClass createDummyClass() {
        System.out.println("create Dummy OnlineClass!");
        return new OnlineClass(99, "dummy", false);
    }
}
