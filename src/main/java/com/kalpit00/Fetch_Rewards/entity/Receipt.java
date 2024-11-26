package com.kalpit00.Fetch_Rewards.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptId; // Use this to uniquely identify each receipt

    @NotBlank
    private String retailerName;
    @NotNull
    private Double total;

    // use Embeddable for Items to create a column in receipt for each item in the collection
    @NotNull
    @ElementCollection
    private List<Item> items;

    // Can also use Strings for date and time. Add data sanitation later
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate purchaseDate;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime purchaseTime;
}
