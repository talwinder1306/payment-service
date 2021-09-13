package com.upgrad.payment.services;

import com.upgrad.payment.entities.TransactionDetailsEntity;
import org.springframework.stereotype.Service;

public interface TransactionDetailsService {

    TransactionDetailsEntity acceptTransactionDetails(TransactionDetailsEntity transactionDetailsEntity);

    TransactionDetailsEntity getTransactionDetails(int transactionId);
}
