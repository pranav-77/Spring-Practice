package desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DesktopMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DesktopMain.class, args);
        Working working = context.getBean(Working.class);
        working.compile();
    }
}
