package com.pranav.springDemo;

import org.springframework.stereotype.Component;

@Component
public class Petrol implements Engine{
    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }
}
