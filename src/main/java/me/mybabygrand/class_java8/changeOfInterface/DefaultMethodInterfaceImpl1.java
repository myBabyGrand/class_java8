package me.mybabygrand.class_java8.changeOfInterface;

public class DefaultMethodInterfaceImpl1 implements DefaultMethodInterface {
    @Override
    public void printClassName() {
        System.out.println(this.getClass().getSimpleName());
    }

    public DefaultMethodInterfaceImpl1() {
    }
}
