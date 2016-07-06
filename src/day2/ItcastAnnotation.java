package day2;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import day1.EnumTest.TrafficLamp;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ItcastAnnotation {
	String color() default "blue";
	String value();
	
	int[] arrayAttr() default {3,4,5};
	TrafficLamp lamp() default TrafficLamp.RED;
	MetaAnnotation annotationAttr() default @MetaAnnotation("1hm");

}
