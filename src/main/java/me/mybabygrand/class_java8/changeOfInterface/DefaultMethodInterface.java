package me.mybabygrand.class_java8.changeOfInterface;

import java.util.Locale;

public interface DefaultMethodInterface {

    void printClassName();

    default void printUpperClassName(){
        System.out.println(this.getClass().getSimpleName().toUpperCase(Locale.ROOT));
    }
}
