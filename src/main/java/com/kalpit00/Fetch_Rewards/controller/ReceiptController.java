package com.kalpit00.Fetch_Rewards.controller;

import com.kalpit00.Fetch_Rewards.dto.PointsResponse;
import com.kalpit00.Fetch_Rewards.dto.Request;
import com.kalpit00.Fetch_Rewards.dto.Response;
import com.kalpit00.Fetch_Rewards.service.ReceiptService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/receipts")

public class ReceiptController {
    private static final Logger log = LoggerFactory.getLogger(ReceiptController.class);
    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/process")
    public ResponseEntity<Response> process(@RequestBody @Valid Request receiptRequest) {
        log.info("Receipt request: " + receiptRequest);
        String id = receiptService.processReceipt(receiptRequest);
        return new ResponseEntity<>(new Response(id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<Object> getReceiptPoints(@PathVariable @Valid String id) {
        log.info("Points requested for receipt with id: " + id);
        Integer points = receiptService.getReceiptPoints(id);
        if (points == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Receipt with id : {" + id + "} does not exist.");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new PointsResponse(points), HttpStatus.OK);
        }
    }


}
