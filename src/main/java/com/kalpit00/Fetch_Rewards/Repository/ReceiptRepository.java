package com.kalpit00.Fetch_Rewards.Repository;

import com.kalpit00.Fetch_Rewards.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}