package com.kalpit00.Fetch_Rewards.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// for now, use a normal embeddable POJO class.
// later can add primary id to uniquely identify each item across multiple receipts
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @NotNull
    @NotBlank
    private String shortDescription;

    @NotNull
    @Min(0)
    @Max(Long.MAX_VALUE)
    private Double price;
}
