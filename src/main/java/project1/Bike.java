package project1;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Driving Bike");
    }
}
