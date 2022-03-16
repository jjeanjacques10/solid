package com.jjeanjacques.solidgood.controller;

import com.jjeanjacques.solidgood.controller.dto.PaymentDTO;
import com.jjeanjacques.solidgood.controller.dto.PaymentLoanResponseDTO;
import com.jjeanjacques.solidgood.controller.dto.PaymentResponseDTO;
import com.jjeanjacques.solidgood.service.Loan;
import com.jjeanjacques.solidgood.service.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    Wallet wallet;

    @Autowired
    Loan loan;

    @PostMapping("/wallet")
    public ResponseEntity<PaymentResponseDTO> wallet(@RequestBody PaymentDTO paymentDTO) {
        wallet.initiatePayments(paymentDTO.getItems());

        var paymentResponse = PaymentResponseDTO.builder()
                .status(wallet.status())
                .items(wallet.getItems())
                .build();

        return ResponseEntity.ok(paymentResponse);
    }

    @PostMapping("/loan")
    public ResponseEntity<PaymentLoanResponseDTO> loan(@RequestBody PaymentDTO paymentDTO) {
        loan.intiateLoanSettlement(paymentDTO.getItems());

        var paymentResponse = PaymentLoanResponseDTO.builder()
                .status(loan.status())
                .items(loan.getItems())
                .build();

        return ResponseEntity.ok(paymentResponse);
    }
}
