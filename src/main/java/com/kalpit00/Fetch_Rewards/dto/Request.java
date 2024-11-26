package com.kalpit00.Fetch_Rewards.dto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor

public class Request {
    public Request(String receiptId, String retailer, String total, List<ItemRequest> items, LocalDate purchaseDate, LocalTime purchaseTime) {
        this.receiptId = receiptId;
        this.retailer = retailer;
        this.total = total;
        this.items = items;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public @NotBlank @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "Retailer can only contain alphanumeric characters, spaces, hyphens, and ampersands.") String getRetailer() {
        return retailer;
    }

    public void setRetailer(@NotBlank @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "Retailer can only contain alphanumeric characters, spaces, hyphens, and ampersands.") String retailer) {
        this.retailer = retailer;
    }

    public @NotNull @DecimalMin(value = "0.00", inclusive = false, message = "Total must be greater than 0") @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Total must have exactly two decimal places") String getTotal() {
        return total;
    }

    public void setTotal(@NotNull @DecimalMin(value = "0.00", inclusive = false, message = "Total must be greater than 0") @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Total must have exactly two decimal places") String total) {
        this.total = total;
    }

    public @NotNull @Size(min = 1) @Valid List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(@NotNull @Size(min = 1) @Valid List<ItemRequest> items) {
        this.items = items;
    }

    public @NotNull LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(@NotNull LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public @NotNull LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(@NotNull LocalTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

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

