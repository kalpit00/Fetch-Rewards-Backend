package com.kalpit00.Fetch_Rewards.service;

import com.kalpit00.Fetch_Rewards.repository.ReceiptRepository;
import com.kalpit00.Fetch_Rewards.dto.ItemRequest;
import com.kalpit00.Fetch_Rewards.dto.Request;
import com.kalpit00.Fetch_Rewards.entity.Item;
import com.kalpit00.Fetch_Rewards.entity.Receipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReceiptService {
    private static final Logger log = LoggerFactory.getLogger(ReceiptService.class);

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private PointsCalculator pointsCalculator;

    public String processReceipt(Request receiptRequest) {
        // Creating Receipt object manually
        Receipt receipt = new Receipt(
                receiptRequest.getRetailer(),
                Double.valueOf(receiptRequest.getTotal()),
                receiptRequest.getPurchaseDate(),
                receiptRequest.getPurchaseTime(),
                new ArrayList<>(), 0);
        for (ItemRequest itemRequest : receiptRequest.getItems()) {
            Item item = new Item(
                    itemRequest.getShortDescription(),
                    Double.valueOf(itemRequest.getPrice())
            );
            receipt.getItems().add(item);
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
