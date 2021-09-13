package com.upgrad.payment.controller;

import com.upgrad.payment.dto.TransactionDetailsDTO;
import com.upgrad.payment.entities.TransactionDetailsEntity;
import com.upgrad.payment.services.TransactionDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/payment")
public class TransactionDetailsController {

    @Autowired
    TransactionDetailsService transactionDetailsService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * It sends the payment transaction to be saved it in the database. It returns the
     * transaction id on successful call.
     * @param transactionDetailsDTO
     * @return
     */
    @PostMapping(value="/transaction", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTransaction(@Valid @RequestBody TransactionDetailsDTO transactionDetailsDTO) {
        TransactionDetailsEntity newTransactionDetailsEntity = modelMapper.map(transactionDetailsDTO, TransactionDetailsEntity.class);

        TransactionDetailsEntity savedTransactionDetailsEntity = transactionDetailsService.acceptTransactionDetails(newTransactionDetailsEntity);

        return new ResponseEntity(savedTransactionDetailsEntity.getId(), HttpStatus.CREATED);
    }

    /**
     * This method finds the transaction with passed transactionId
     * If not found it returns message Not Found
     * @param transactionId
     * @return TransactionDetailsEntity
     */
    @GetMapping(value="/transaction/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransactionById(@PathVariable(name = "transactionId") int transactionId) {
        TransactionDetailsEntity retrievedTransactionDetailsEntity = transactionDetailsService.getTransactionDetails(transactionId);
        if(retrievedTransactionDetailsEntity == null)
            return new ResponseEntity("Transaction with transactionId " + transactionId + " not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity(retrievedTransactionDetailsEntity, HttpStatus.OK);
    }

}
