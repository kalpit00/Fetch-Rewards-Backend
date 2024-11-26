package com.kalpit00.Fetch_Rewards.service;

import com.kalpit00.Fetch_Rewards.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;
}
