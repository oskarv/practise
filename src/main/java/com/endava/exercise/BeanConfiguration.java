package com.endava.exercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("anja")
    public Pilot createPilot(){
        Pilot pilot = new Pilot("Anja");
        return pilot;
    }

    @Bean("airbus")
    public Airplane createAirplane(){
        Airplane airplane = new Airplane(createPilot(),25);
        return airplane;
    }
}
