package com.kalpit00.Fetch_Rewards.entity;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// for now, use a normal embeddable POJO class.
// later can add primary id to uniquely identify each item across multiple receipts
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {
    private String shortDescription;
    private Double price;
}
