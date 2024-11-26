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

import org.springframework.format.annotation.DateTimeFormat;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // GenerationType.AUTO for integer ids
    private String receiptId; // Use this to uniquely identify each receipt during testing with postman

    @NotBlank
    private String retailer;
    @NotNull
    private Double total;

    @NotNull
    private List<ItemRequest> items;

    @NotNull
    @DateTimeFormat(pattern = "YYYY:MM:dd")
    private LocalDate purchaseDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime purchaseTime;
}

