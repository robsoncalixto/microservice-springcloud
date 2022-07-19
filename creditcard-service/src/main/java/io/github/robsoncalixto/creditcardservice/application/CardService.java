package io.github.robsoncalixto.creditcardservice.application;

import io.github.robsoncalixto.creditcardservice.domain.Card;
import io.github.robsoncalixto.creditcardservice.infra.repository.CardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRep;

    public CardService(CardRepository cardRep) {
        this.cardRep = cardRep;
    }

    @Transactional
    public Card save(Card card){
        return cardRep.save(card);
    }

    public List<Card> getCardsIncomeLessThanEqual(Long income){
        var bigDecimalIncome = BigDecimal.valueOf(income);
        return cardRep.findByIncomeLessThanEqual(bigDecimalIncome);
    }
}
