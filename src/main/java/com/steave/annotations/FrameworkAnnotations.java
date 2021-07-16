package com.steave.annotations;


import com.steave.enums.TestTagAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations{
    String[] authors();
    TestTagAnnotation[] testTags();
}
