package com.kalpit00.Fetch_Rewards.dto;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Response {
    String id; // For now, we are only asked to send the receipt id as response!

    public Response(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // But via this Response object, we can send entire receipt or any specific fields only
}
