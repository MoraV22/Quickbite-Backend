package com.quickbite.backend.user.repository;

import com.quickbite.backend.user.domain.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Integer> {
    List<PaymentInfo> findPaymentInfoByUserId(Integer userId);
}
