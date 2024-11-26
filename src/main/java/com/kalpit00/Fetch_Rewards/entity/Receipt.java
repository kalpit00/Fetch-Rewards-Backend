package com.kalpit00.Fetch_Rewards.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor

public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // UUID is expected in response as a string for ids
    private String receiptId;
    private Integer points;
    private String retailer;
    private Double total;
    @ElementCollection
    private List<Item> items;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;

    public Receipt(String retailer, Double total, LocalDate purchaseDate,
                   LocalTime purchaseTime, List<Item> items, Integer points) {
        this.points = points;
        this.retailer = retailer;
        this.total = total;
        this.items = items;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
    }

    public Receipt(String receiptId, Integer points, String retailer, Double total, List<Item> items, LocalDate purchaseDate, LocalTime purchaseTime) {
        this.receiptId = receiptId;
        this.points = points;
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
