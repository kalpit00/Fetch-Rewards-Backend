package com.kalpit00.Fetch_Rewards.model;

// simple POJO for item model. Here we are modeling only price and description, but we can add extra
// information like quantity, etc

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {
    private String shortDescription;
    private Double price;
}
