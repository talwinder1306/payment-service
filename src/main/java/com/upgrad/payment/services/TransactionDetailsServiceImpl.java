package com.upgrad.payment.services;

import com.upgrad.payment.dao.TransactionDetailsDao;
import com.upgrad.payment.entities.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

    @Autowired
    TransactionDetailsDao transactionDetailsDao;

    /**
     * This method accepts the payment transaction and saves it in the database.
     * @param transactionDetailsEntity
     * @return TransactionDetailsEntity
     */
    @Override
    public TransactionDetailsEntity acceptTransactionDetails(TransactionDetailsEntity transactionDetailsEntity) {
        return transactionDetailsDao.save(transactionDetailsEntity);
    }

    /**
     * This method fetches the transaction with the transactionId passed as argument
     * @param transactionId
     * @return TransactionDetailsEntity
     */
    @Override
    public TransactionDetailsEntity getTransactionDetails(int transactionId) {
        Optional<TransactionDetailsEntity> transactionDetailsEntityOptional = transactionDetailsDao.findById(transactionId);
        if(!transactionDetailsEntityOptional.isPresent()) {
            return null;
        }
        return transactionDetailsEntityOptional.get();
    }
}
