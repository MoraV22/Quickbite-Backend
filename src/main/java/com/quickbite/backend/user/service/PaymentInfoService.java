package com.quickbite.backend.user.service;

import com.quickbite.backend.user.domain.PaymentInfo;
import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.dto.PaymentInfoDTO;
import com.quickbite.backend.user.repository.PaymentInfoRepository;
import com.quickbite.backend.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PaymentInfoDTO createPaymentInfo(PaymentInfoDTO paymentInfoDTO) {
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

        PaymentInfo savedPaymentInfo = paymentInfoRepository.save(paymentInfo);
        return convertToDTO(savedPaymentInfo);
    }

    /**
     * Update payment info using only the User ID
     * This avoids loading the entire User object
     */
    @Transactional
    public PaymentInfoDTO updatePaymentInfo(Integer paymentInfoId, PaymentInfoDTO paymentInfoDTO) {
        PaymentInfo paymentInfo = paymentInfoRepository.findById(paymentInfoId);

        if (paymentInfoRepository.existsById(paymentInfo.getId())){
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

        PaymentInfo updatedPaymentInfo = paymentInfoRepository.save(paymentInfo);
        return convertToDTO(updatedPaymentInfo);
    }

    /**
     * Get payment info by ID and return as DTO (only includes User ID)
     */
    public PaymentInfoDTO getPaymentInfoById(Integer paymentInfoId) {
        PaymentInfo paymentInfo = paymentInfoRepository.findById(paymentInfoId);

        if(paymentInfoRepository.existsById(paymentInfo.getId())){
                    throw new EntityNotFoundException("Payment info not found with ID: " + paymentInfoId);
                }

        return convertToDTO(paymentInfo);
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

    /**
     * Convert PaymentInfo entity to PaymentInfoDTO
     * Only includes the User ID, not the entire User object
     */
    private PaymentInfoDTO convertToDTO(PaymentInfo paymentInfo) {
        return new PaymentInfoDTO(
                paymentInfo.getId(),
                paymentInfo.getCardLast4(),
                paymentInfo.getBrand(),
                paymentInfo.getExpirationMonth(),
                paymentInfo.getExpirationYear(),
                paymentInfo.getUser().getId()
        );
    }
}
