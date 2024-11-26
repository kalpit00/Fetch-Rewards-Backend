package com.kalpit00.Fetch_Rewards.controller;

import com.kalpit00.Fetch_Rewards.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;
}
