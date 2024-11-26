package com.kalpit00.Fetch_Rewards.entity;

// simple POJO for item model. Here we are modeling only price and description, but we can add extra
// information like quantity, etc

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Item {
    private String shortDescription;
    private Double price;

    public Item(String shortDescription, Double price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
