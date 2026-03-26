package com.example.fragment_thymeleaf.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NayaController {
    @GetMapping("/contentThymeleaf")
    public String getMethodName() {
        return "design";
       
    }

}
