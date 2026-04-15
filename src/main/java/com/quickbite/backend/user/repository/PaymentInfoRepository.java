package com.quickbite.backend.user.repository;

import com.quickbite.backend.user.domain.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Integer> {

    @Query(value = "SELECT p FROM payments_info p WHERE p.id_user= : userId", nativeQuery = true)
    List<PaymentInfo> findByUser(@Param("userId") Integer userId);

    @Query(value = "DELETE FROM payments_info p WHERE p.id= :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);
}
