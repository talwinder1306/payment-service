package com.upgrad.payment.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * This class corresponds to transaction table in the database having transaction details
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name="transaction")
public class TransactionDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transactionId")
    private int id;

    private String paymentMode;

    @Column(nullable = false)
    private int bookingId;

    private String upiId;

    private String cardNumber;

}
