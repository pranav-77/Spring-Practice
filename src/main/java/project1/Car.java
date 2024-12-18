package project1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle
 {
    @Override
    public void drive() {
        System.out.println("Driving car");
    }
}
