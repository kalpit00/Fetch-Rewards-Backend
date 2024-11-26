package com.kalpit00.Fetch_Rewards.service;

import com.kalpit00.Fetch_Rewards.Repository.ReceiptRepository;
import com.kalpit00.Fetch_Rewards.entity.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public Long processReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
        return receipt.getReceiptId();
    }
}
