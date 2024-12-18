package com.pranav.springDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Diesel implements Engine{
    @Override
    public void start() {
        System.out.println("Diesel Engine Started");
    }
}
