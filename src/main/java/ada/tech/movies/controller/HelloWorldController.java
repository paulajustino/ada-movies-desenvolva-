package ada.tech.movies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("{id}")
    public String helloWorld(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "age") Integer age) {
        return "Meu nome é " + name + " e eu tenho " + age + " anos";
    }

}
