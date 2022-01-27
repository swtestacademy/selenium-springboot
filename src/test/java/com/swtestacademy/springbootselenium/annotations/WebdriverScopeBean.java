package com.swtestacademy.springbootselenium.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Bean
@Scope("webdriverscope")
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebdriverScopeBean {
}
