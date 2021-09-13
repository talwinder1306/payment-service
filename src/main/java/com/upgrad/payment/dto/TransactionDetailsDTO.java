package com.upgrad.payment.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class corresponds to the request received for each transaction
 */
@Getter
@Setter
@NoArgsConstructor
public class TransactionDetailsDTO {

    private int transactionId;

    @NotBlank(message = "paymentMode cannot be blank")
    private String paymentMode;

    @NotNull(message = "bookingId cannot be blank")
    private Integer bookingId;

    private String upiId;

    private String cardNumber;

}
