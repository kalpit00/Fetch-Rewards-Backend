package com.kalpit00.Fetch_Rewards.entity;

// simple POJO for item model. Here we are modeling only price and description, but we can add extra
// information like quantity, etc

import jakarta.persistence.Embeddable;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {
    private String shortDescription;
    private Double price;
}
