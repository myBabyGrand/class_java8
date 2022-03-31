package me.mybabygrand.class_java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class IntroduceOfStream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("d");
        names.add("cc");
        names.add("bbb");
        names.add("aaaa");
        names.stream().filter(s->s.length()>2).forEach(System.out::println);

        List<String> list = names.stream().map(s -> s.toUpperCase()).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        list.forEach(System.out::println);

        List<String> collect = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println("==========");
        collect.forEach(System.out::println);

    }
}
