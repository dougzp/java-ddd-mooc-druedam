package tv.codelytv.apps.mooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class GreeterController {

    @GetMapping("/greetings")
    public String getGreetings(@RequestParam(value = "name") String name) {
        return "Hi " + name;
    }

}
