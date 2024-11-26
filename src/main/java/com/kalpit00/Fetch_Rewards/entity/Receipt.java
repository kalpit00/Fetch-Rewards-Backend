package com.kalpit00.Fetch_Rewards.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptId; // Use this to uniquely identify each receipt

    private String retailerName;
    private Double total;

    // use Embeddable for Items to create a column in receipt for each item in the collection
    @ElementCollection
    private List<Item> items;

    // Can also use Strings for date and time. Add data sanitation later
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
}
