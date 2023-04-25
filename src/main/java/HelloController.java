package utad.pepe.taller1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Jorge Bravo";
    }
    @GetMapping("/goodbye")
    public String hello() {
        return "Goodbye Jorge Bravo";
    }

}

