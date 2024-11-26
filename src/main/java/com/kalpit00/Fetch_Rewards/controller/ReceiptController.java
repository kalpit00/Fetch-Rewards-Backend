package com.kalpit00.Fetch_Rewards.controller;

import com.kalpit00.Fetch_Rewards.entity.Request;
import com.kalpit00.Fetch_Rewards.entity.Response;
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
    public ResponseEntity<Response> process(@RequestBody Request receiptRequest) {
        log.info("Receipt request: " + receiptRequest);
        Long id = receiptService.processReceipt(receiptRequest);
        return new ResponseEntity<>(new Response(id), HttpStatus.CREATED);
    }

}
