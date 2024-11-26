package com.kalpit00.Fetch_Rewards.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    String id; // For now, we are only asked to send the receipt id as response!
    // But via this Response object, we can send entire receipt or any specific fields only
}
