package com.kalpit00.Fetch_Rewards.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PointsResponse {
    int points;

    public PointsResponse(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
