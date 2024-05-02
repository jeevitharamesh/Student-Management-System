package com.skiply.skiply.controller;

import com.skiply.skiply.Exception.ReceiptNotFoundException;
import com.skiply.skiply.Exception.StudentNotFoundException;
import com.skiply.skiply.entity.Receipt;
import com.skiply.skiply.service.FeePaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FeePaymentController {

    @Autowired
    FeePaymentService feePaymentService;

    @GetMapping("/receipts/{id}")

    public ResponseEntity<Receipt> viewReceipt(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(feePaymentService.viewReceipt(id), HttpStatus.OK);
        }catch (ReceiptNotFoundException exception){
            throw new ReceiptNotFoundException("No Receipt found for the id: " + id);
        }
    }

    @PostMapping("/receipts")
    public ResponseEntity<Receipt> payFee(@RequestBody @Valid Receipt receipt){
        try {
            return new ResponseEntity<>(feePaymentService.payFee(receipt), HttpStatus.CREATED);
        }catch (StudentNotFoundException exception) {
            throw new StudentNotFoundException("No Student found for the id: " + receipt.getStudent().getId());
        }
    }
}
