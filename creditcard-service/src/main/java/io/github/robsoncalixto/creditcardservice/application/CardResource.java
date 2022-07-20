package io.github.robsoncalixto.creditcardservice.application;

import io.github.robsoncalixto.creditcardservice.application.representation.SaveCardRequest;
import io.github.robsoncalixto.creditcardservice.domain.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income ){
        var cards = service.getCardsIncomeLessThanEqual(income);
        return ResponseEntity.ok(cards);

    }
}
