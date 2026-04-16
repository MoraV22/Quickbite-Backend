package com.quickbite.backend.user.controller;

import com.quickbite.backend.user.domain.PaymentInfo;
import com.quickbite.backend.user.dto.PaymentInfoDTO;
import com.quickbite.backend.user.service.PaymentInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/payment-info")
@CrossOrigin(origins = "*")
public class PaymentInfoController {


    private final PaymentInfoService paymentInfoService;
    public PaymentInfoController(PaymentInfoService paymentInfoService) {
        this.paymentInfoService = paymentInfoService;
    }

    /**
     * Add a payment method to a user
     * POST /api/payment-info
     */
    @PostMapping
    public ResponseEntity<PaymentInfo> createPaymentInfo(@Valid @RequestBody PaymentInfoDTO paymentInfoDTO) {
        PaymentInfo createdPaymentInfo = paymentInfoService.createPaymentInfo(paymentInfoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaymentInfo);
    }

    /**
     * Update a payment info
     * PUT /api/payment-info/id({id}
     */
    @PutMapping("/id/{id}")
    public ResponseEntity<PaymentInfo> updatePaymentInfo(@PathVariable Integer id, @Valid @RequestBody PaymentInfoDTO paymentInfoDTO) {
        if(!Objects.equals(paymentInfoDTO.getId(), id)){
            return  ResponseEntity.badRequest().build();
        }
        PaymentInfo updatedPaymentInfo = paymentInfoService.updatePaymentInfo(id, paymentInfoDTO);
        return ResponseEntity.ok(updatedPaymentInfo);
    }

    /**
     * Get payment info by id
     * GET api/payment-info/id/{id}
      */
    @GetMapping("/id/{id}")
    public ResponseEntity<PaymentInfo> getPaymentInfoById(@PathVariable Integer id) {
        PaymentInfo paymentInfo = paymentInfoService.getPaymentInfoById(id);
        return ResponseEntity.ok(paymentInfo);
    }

     /**
     * Get payment info by user id
     * GET api/payment-info/userId/{userId}
      */
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<PaymentInfo>> getPaymentInfoByUserId(@PathVariable Integer userId) {
        List<PaymentInfo> paymentInfos = paymentInfoService.getPaymentInfoByUserId(userId);
        return ResponseEntity.ok(paymentInfos);
    }

    /**
     * Delete payment info
     * DELETE api/payment-info/id/{id}
     */
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletePaymentInfo(@PathVariable Integer id) {
        paymentInfoService.deletePaymentInfo(id);
        return ResponseEntity.noContent().build();
    }
}
