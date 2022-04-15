package me.mybabygrand.class_java8.theOthers;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(value = ChickenContainer.class)
public @interface Chicken {
    String value();
}
