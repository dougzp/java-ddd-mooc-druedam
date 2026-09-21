package tv.codelytv.apps.mooc.controller.health_check;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public final class GreeterGetController {

    @GetMapping("/greeter")
    public String index(@RequestParam String name) {
        if (Objects.isNull(name)) name = "unnamed";

        return "Hello " + name + "!";
    }
}
