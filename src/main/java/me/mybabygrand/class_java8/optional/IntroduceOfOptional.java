package me.mybabygrand.class_java8.optional;

import me.mybabygrand.class_java8.OnlineClass;
import me.mybabygrand.class_java8.Progress;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IntroduceOfOptional {
    static List<OnlineClass> springClasses = null;
    public static void main(String[] args) {
        makeSample();
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        spring_boot.getProgress().ifPresent(p-> {
            System.out.println("1 "+p.getStudyDuration().getSeconds());
        });
        spring_boot.setProgress(new Progress(Duration.ofHours(1L), false));
//        System.out.println(spring_boot.getProgress().get().getStudyDuration().getSeconds());
//        System.out.println(spring_boot.getProgress().isPresent());
        spring_boot.getProgress().ifPresent(p-> {
            System.out.println("2 "+p.getStudyDuration().getSeconds());
        });

    }
    private static void makeSample() {
        springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

    }
}
