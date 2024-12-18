package project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driving {
    @Autowired
    @Qualifier("bike")
    private Vehicle vehicle;

    public void driving () {
        vehicle.drive();
        System.out.println("Drive Successful");
    }
}
