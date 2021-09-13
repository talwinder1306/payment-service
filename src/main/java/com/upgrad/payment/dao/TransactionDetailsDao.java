package com.upgrad.payment.dao;

import com.upgrad.payment.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsDao extends JpaRepository<TransactionDetailsEntity, Integer> {
}
