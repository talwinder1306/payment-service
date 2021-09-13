package com.upgrad.payment.model;

import com.upgrad.payment.dto.TransactionDetailsDTO;
import com.upgrad.payment.entities.TransactionDetailsEntity;
import org.modelmapper.PropertyMap;

/**
 * This class maps the TransactionDetailsDTO transactionId to TransactionDetailsEntity id field
 */
public class TransactionDetailsMap extends PropertyMap<TransactionDetailsDTO, TransactionDetailsEntity>{
    protected void configure(){
        map().setId(source.getTransactionId());
    }
}

