package com.kalpit00.Fetch_Rewards.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// for now, use a normal embeddable POJO class.
// later can add primary id to uniquely identify each item across multiple receipts
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @NotBlank
    @Pattern(regexp = "^[\\w\\s\\-]+$", message = "Short description can only contain alphanumeric characters, spaces, and hyphens.")
    private String shortDescription;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Price must have exactly two decimal places")
    private String price;

}
