package me.mybabygrand.class_java8.changeOfInterface;

import java.util.Locale;

public class DefaultInterfaceImpl2 implements DefaultMethodInterface {
    @Override
    public void printClassName() {
        System.out.println(this.getClass().getName());
    }

    @Override
    public void printUpperClassName() {
        System.out.println(this.getClass().getName().toUpperCase(Locale.ROOT));
    }

    public DefaultInterfaceImpl2() {
    }
}
