package com.kalpit00.Fetch_Rewards.service;

import com.kalpit00.Fetch_Rewards.entity.Receipt;
import org.springframework.stereotype.Service;

@Service
public class PointsCalculator {

    public int calculatePoints(Receipt receipt) {
        int totalPoints = 0;

        totalPoints += calculateRetailerPoints(receipt);
        totalPoints += calculateRoundDollarPoints(receipt);
        totalPoints += calculateMultipleOf25Points(receipt);
        totalPoints += calculateItemsPoints(receipt);
        totalPoints += calculateItemDescriptionPoints(receipt);
        totalPoints += calculateOddDayPoints(receipt);
        totalPoints += calculateTimePoints(receipt);

        return totalPoints;
    }

    private int calculateRetailerPoints(Receipt receipt) {
        String retailer = receipt.getRetailer();
        return (int) retailer.chars().filter(Character::isLetterOrDigit).count();
    }

    private int calculateRoundDollarPoints(Receipt receipt) {
        return receipt.getTotal() % 1 == 0 ? PointsConstants.ROUND_DOLLAR_BONUS : 0;
    }

    private int calculateMultipleOf25Points(Receipt receipt) {
        return receipt.getTotal() % 0.25 == 0 ? PointsConstants.MULTIPLE_OF_25_BONUS : 0;
    }

    private int calculateItemsPoints(Receipt receipt) {
        return (receipt.getItems().size() / 2) * PointsConstants.ITEMS_PAIR_BONUS;
    }

    private int calculateItemDescriptionPoints(Receipt receipt) {
        return receipt.getItems().stream()
                .filter(item -> item.getShortDescription().trim().length() % 3 == 0)
                .mapToInt(item -> (int) Math.ceil(item.getPrice() * PointsConstants.ITEM_DESC_MULTIPLIER))
                .sum();
    }

    private int calculateOddDayPoints(Receipt receipt) {
        return receipt.getPurchaseDate().getDayOfMonth() % 2 != 0 ? PointsConstants.ODD_DAY_BONUS : 0;
    }

    private int calculateTimePoints(Receipt receipt) {
        int hour = receipt.getPurchaseTime().getHour();
        return hour >= PointsConstants.AFTERNOON_START_HOUR && hour < PointsConstants.AFTERNOON_END_HOUR
                ? PointsConstants.TIME_BONUS
                : 0;
    }
}

