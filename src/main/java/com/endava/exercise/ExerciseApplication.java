package com.endava.exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Airplane airplane = context.getBean("airplane1", Airplane.class);
		System.out.println(airplane.toString());
		System.out.println("Pilot's name is: " + airplane.getPilot().getName());

	}

}
