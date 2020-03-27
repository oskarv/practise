package com.endava.exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ExerciseApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExerciseApplication.class);

		Airplane airplane = context.getBean("airbus", Airplane.class);
		System.out.println(airplane.toString());
		System.out.println("Pilot's name is: " + airplane.getPilot().getName());
	}

}
