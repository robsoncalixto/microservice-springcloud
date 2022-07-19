package io.github.robsoncalixto.creditcardservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Card() {
    }

    public Card(String name, CardBrand brand, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.basicLimit = limit;
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

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }

    public void setBasicLimit(BigDecimal limit) {
        this.basicLimit = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return id.equals(card.id) && name.equals(card.name) && brand == card.brand && income.equals(card.income) && basicLimit.equals(card.basicLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, income, basicLimit);
    }
}
