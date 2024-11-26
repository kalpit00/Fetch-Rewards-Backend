package com.kalpit00.Fetch_Rewards.service;

import com.kalpit00.Fetch_Rewards.repository.ReceiptRepository;
import com.kalpit00.Fetch_Rewards.dto.ItemRequest;
import com.kalpit00.Fetch_Rewards.dto.Request;
import com.kalpit00.Fetch_Rewards.entity.Item;
import com.kalpit00.Fetch_Rewards.entity.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private PointsCalculator pointsCalculator;

    public String processReceipt(Request receiptRequest) {
        Receipt receipt = Receipt.builder().
                retailer(receiptRequest.getRetailer()).
                total(Double.valueOf(receiptRequest.getTotal())).
                purchaseDate(receiptRequest.getPurchaseDate()).
                purchaseTime(receiptRequest.getPurchaseTime()).
                items(new ArrayList<>()).build();
        for (ItemRequest itemRequest : receiptRequest.getItems()) {
            receipt.getItems().add(Item.builder().shortDescription(itemRequest.getShortDescription()).
                    price(Double.valueOf(itemRequest.getPrice())).build());
        }
        receipt.setPoints(pointsCalculator.calculatePoints(receipt));
        log.info("Receipt object: " + receipt + " with points: " + receipt.getPoints());
        receiptRepository.save(receipt);
        return receipt.getReceiptId();
    }

    public Integer getReceiptPoints(String id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        return receipt.map(Receipt::getPoints).orElse(null);
    }
}
