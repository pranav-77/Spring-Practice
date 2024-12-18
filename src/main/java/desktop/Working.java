package desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Working {
    @Autowired
    private Computer computer;

    public void compile() {
        computer.work();
        System.out.println("Worked Successfully");
    }
}
