package com.kalpit00.Fetch_Rewards.dto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "Retailer can only contain alphanumeric characters, spaces, hyphens, and ampersands.")
    private String retailer;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false, message = "Total must be greater than 0")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Total must have exactly two decimal places")
    private String total;


    @NotNull
    @Size(min = 1)
    @Valid // Triggers validation on each `ItemRequest` in the list.
    private List<ItemRequest> items;

    @NotNull
    @DateTimeFormat(pattern = "YYYY:MM:dd")
    private LocalDate purchaseDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime purchaseTime;
}

