package com.dauphine.blogger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(
        name = "Hello world API",
        description = "My First hello world endpoints"
)
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("hello")
    public String helloByName(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("hello/{name}")
    @Operation(
        summary = "Hello by name endpoint",
            description = "Returns 'Hello {name}', by path variable"
    )
    public String hello(@Parameter(description = "Name to greet") @PathVariable String name) {
        return "Hello " + name;
    }
}
