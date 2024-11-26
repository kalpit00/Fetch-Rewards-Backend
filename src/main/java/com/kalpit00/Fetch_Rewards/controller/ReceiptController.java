package com.kalpit00.Fetch_Rewards.controller;

import com.kalpit00.Fetch_Rewards.entity.Receipt;
import com.kalpit00.Fetch_Rewards.service.ReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/receipts")

public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/process")
    public ResponseEntity<Receipt> process(@RequestBody Receipt receipt) {
        log.info("Process request received: " + receipt);
        Long id = receiptService.processReceipt(receipt);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
