package me.mybabygrand.class_java8.chageOfInterface;

import me.mybabygrand.class_java8.changeOfInterface.*;
import org.junit.jupiter.api.Test;

public class ChangeOfInterfaceTest {

    @Test
    void defaultInterfaceTest(){
        DefaultMethodInterface defaultMethodInterface1 = new DefaultMethodInterfaceImpl1();
        DefaultMethodInterface defaultMethodInterface2 = new DefaultInterfaceImpl2();

        defaultMethodInterface1.printClassName();
        defaultMethodInterface2.printClassName();

        defaultMethodInterface1.printUpperClassName();
        defaultMethodInterface2.printUpperClassName();

    }

    @Test
    void defaultInterface2Test(){
        DefaultMethodInterface2 defaultMethodInterface2 = new DefaultMethodInterface2Impl();
        defaultMethodInterface2.printClassName();
        defaultMethodInterface2.printUpperClassName();
    }

    @Test
    void staticMethodInterfaceTest(){
        StaticMethodInterface staticMethodInterface = new StaticMethodInterfaceImpl();
        StaticMethodInterface.printAnything();
    }
}
