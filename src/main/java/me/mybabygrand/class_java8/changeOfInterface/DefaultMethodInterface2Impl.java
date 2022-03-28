package me.mybabygrand.class_java8.changeOfInterface;

public class DefaultMethodInterface2Impl implements DefaultMethodInterface2 {

    @Override
    public void printClassName() {
        System.out.println("전혀 새로운 이름");
    }

    @Override
    public void printUpperClassName() {
        System.out.println(this.getClass().getSimpleName().toLowerCase());
    }
}
