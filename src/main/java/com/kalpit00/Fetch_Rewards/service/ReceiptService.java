package com.kalpit00.Fetch_Rewards.service;

import com.kalpit00.Fetch_Rewards.Repository.ReceiptRepository;
import com.kalpit00.Fetch_Rewards.entity.ItemRequest;
import com.kalpit00.Fetch_Rewards.entity.Request;
import com.kalpit00.Fetch_Rewards.model.Item;
import com.kalpit00.Fetch_Rewards.model.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public String processReceipt(Request receiptRequest) {
        Receipt receipt = Receipt.builder().
                retailer(receiptRequest.getRetailer()).
                total(receiptRequest.getTotal()).
                purchaseDate(receiptRequest.getPurchaseDate()).
                purchaseTime(receiptRequest.getPurchaseTime()).
                items(new ArrayList<>()).build();
        for (ItemRequest itemRequest : receiptRequest.getItems()) {
            receipt.getItems().add(Item.builder().shortDescription(itemRequest.getShortDescription()).
                    price(itemRequest.getPrice()).build());
        }
        receipt.setPoints(calculatePoints(receipt));
        log.info("Receipt object: " + receipt + " with points: " + receipt.getPoints());
        receiptRepository.save(receipt);
        return receipt.getReceiptId();
    }
    public int calculatePoints(Receipt receipt) {
        return 5;
    }
    public Integer getReceiptPoints(String id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        return receipt.map(Receipt::getPoints).orElse(null);
    }
}
