package com.kalpit00.Fetch_Rewards.model;
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
    private Long receiptId;
    private Integer points;
    private String retailer;
    private Double total;
    @ElementCollection
    private List<Item> items;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
}
