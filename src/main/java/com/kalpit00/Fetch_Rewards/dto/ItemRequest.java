package com.kalpit00.Fetch_Rewards.dto;

import jakarta.validation.constraints.*;
import lombok.*;


// for now, use a normal embeddable POJO class.
// later can add primary id to uniquely identify each item across multiple receipts
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    public @NotBlank @Pattern(regexp = "^[\\w\\s\\-]+$", message = "Short description can only contain alphanumeric characters, spaces, and hyphens.") String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(@NotBlank @Pattern(regexp = "^[\\w\\s\\-]+$", message = "Short description can only contain alphanumeric characters, spaces, and hyphens.") String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public @NotNull @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0") @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Price must have exactly two decimal places") String getPrice() {
        return price;
    }

    public void setPrice(@NotNull @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0") @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Price must have exactly two decimal places") String price) {
        this.price = price;
    }

    @NotBlank
    @Pattern(regexp = "^[\\w\\s\\-]+$", message = "Short description can only contain alphanumeric characters, spaces, and hyphens.")
    private String shortDescription;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Price must have exactly two decimal places")
    private String price;

}
