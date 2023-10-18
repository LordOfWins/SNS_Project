package org.spring.lazy_init;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
//초기화 할 때 호출됨
public class ClassB {
    public final ClassA classA;

    ClassB(ClassA classA) {
        System.out.println("Initializing ClassB");
        this.classA = classA;
    }
}
