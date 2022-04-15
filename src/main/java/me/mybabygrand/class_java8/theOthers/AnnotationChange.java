package me.mybabygrand.class_java8.theOthers;

import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘")
@Chicken("간장")
public class AnnotationChange {
    public static void main(String[] args) {

        ChickenContainer chickenContainer = AnnotationChange.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }
}
