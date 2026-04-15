package com.quickbite.backend.user.service;

import com.quickbite.backend.user.domain.PaymentInfo;
import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.dto.PaymentInfoDTO;
import com.quickbite.backend.user.repository.PaymentInfoRepository;
import com.quickbite.backend.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentInfoService {

    private final PaymentInfoRepository paymentInfoRepository;
    private final UserRepository userRepository;

    public PaymentInfoService(PaymentInfoRepository paymentInfoRepository, UserRepository userRepository) {
        this.paymentInfoRepository = paymentInfoRepository;
        this.userRepository = userRepository;
    }

    /**
     * Create a new payment info using only the User ID
     * This avoids loading the entire User object
     */
    @Transactional
    public PaymentInfo createPaymentInfo(PaymentInfoDTO paymentInfoDTO) {
        // Verify that the user exists with the given ID
        User user = userRepository.findById(paymentInfoDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + paymentInfoDTO.getUserId()));

        // Create PaymentInfo entity
        PaymentInfo paymentInfo = new PaymentInfo(
                paymentInfoDTO.getCardLast4(),
                paymentInfoDTO.getBrand(),
                paymentInfoDTO.getExpirationMonth(),
                paymentInfoDTO.getExpirationYear(),
                user
        );


        return paymentInfoRepository.save(paymentInfo);
    }

    /**
     * Update payment info using only the User ID
     * This avoids loading the entire User object
     */
    @Transactional
    public PaymentInfo updatePaymentInfo(Integer paymentInfoId, PaymentInfoDTO paymentInfoDTO) {
        PaymentInfo paymentInfo = paymentInfoRepository.findById(paymentInfoId)
                .orElseThrow(() -> new EntityNotFoundException("Payment info not found with ID: " + paymentInfoId));


        if (!paymentInfoRepository.existsById(paymentInfo.getId())){
            throw new EntityNotFoundException("Payment info not found with ID: " + paymentInfoId);
        }

        // If user ID is being updated, verify the new user exists
        if (!paymentInfo.getUser().getId().equals(paymentInfoDTO.getUserId())) {
            User user = userRepository.findById(paymentInfoDTO.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + paymentInfoDTO.getUserId()));
            paymentInfo.setUser(user);
        }

        paymentInfo.setCardLast4(paymentInfoDTO.getCardLast4());
        paymentInfo.setBrand(paymentInfoDTO.getBrand());
        paymentInfo.setExpirationMonth(paymentInfoDTO.getExpirationMonth());
        paymentInfo.setExpirationYear(paymentInfoDTO.getExpirationYear());


        return paymentInfoRepository.save(paymentInfo);
    }

    /**
     * Get payment info by ID
     */
    public PaymentInfo getPaymentInfoById(Integer paymentInfoId) {
        PaymentInfo paymentInfo = paymentInfoRepository.findById(paymentInfoId)
                .orElseThrow(() -> new EntityNotFoundException("Payment info not found with ID: " + paymentInfoId));


        if(!paymentInfoRepository.existsById(paymentInfo.getId())){
                    throw new EntityNotFoundException("Payment info not found with ID: " + paymentInfoId);
                }

        return paymentInfo;
    }

    public List<PaymentInfo> getPaymentInfoByUserId(Integer userId) {
        if(!paymentInfoRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found with ID: " + userId);
        }
        return paymentInfoRepository.findByUser(userId);
    }

    /**
     * Delete payment info by ID
     */
    @Transactional
    public void deletePaymentInfo(Integer paymentInfoId) {
        if (!paymentInfoRepository.existsById(paymentInfoId)) {
            throw new EntityNotFoundException("Payment info not found with ID: " + paymentInfoId);
        }
        paymentInfoRepository.deleteById(paymentInfoId);
    }

}
