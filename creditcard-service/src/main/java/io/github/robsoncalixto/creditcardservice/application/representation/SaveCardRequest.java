package io.github.robsoncalixto.creditcardservice.application.representation;

import io.github.robsoncalixto.creditcardservice.domain.Card;
import io.github.robsoncalixto.creditcardservice.domain.CardBrand;

import java.math.BigDecimal;

public class SaveCardRequest {
    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toModel(){
        return new Card(name, brand,income, limit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardBrand getBrand() {
        return brand;
    }

    public void setBrand(CardBrand brand) {
        this.brand = brand;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
