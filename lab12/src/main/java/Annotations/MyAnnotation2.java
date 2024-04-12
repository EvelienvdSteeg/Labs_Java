package Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MyAnnotation2 {
    String value = "Hello2";
}
