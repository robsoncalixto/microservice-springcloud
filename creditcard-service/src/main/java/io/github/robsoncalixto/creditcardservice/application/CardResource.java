package io.github.robsoncalixto.creditcardservice.application;

import io.github.robsoncalixto.creditcardservice.application.representation.SaveCardRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardResource {

    private final CardService service;

    public CardResource(CardService service) {
        this.service = service;
    }

    @GetMapping
    public String status(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SaveCardRequest request){
        var card = request.toModel();
        service.save(card);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
