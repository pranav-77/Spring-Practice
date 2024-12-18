package com.pranav.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;

//    Car(Engine engine) {
//        this.engine = engine;
//    }

    public void drive () {
        engine.start();
        System.out.println("Car is moving");
    }

    @Autowired
//    @Qualifier("petrol")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
