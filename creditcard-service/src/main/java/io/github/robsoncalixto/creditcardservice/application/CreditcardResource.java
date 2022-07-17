package io.github.robsoncalixto.creditcardservice.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-card")
public class CreditcardResource {

    @GetMapping
    public String status(){
        return "Ok";
    }
}
