package com.jjeanjacques.solidbad.controller;

import com.jjeanjacques.solidbad.controller.dto.PaymentDTO;
import com.jjeanjacques.solidbad.controller.dto.PaymentLoanResponseDTO;
import com.jjeanjacques.solidbad.controller.dto.PaymentResponseDTO;
import com.jjeanjacques.solidbad.interfaces.Payment;
import com.jjeanjacques.solidbad.service.LoanService;
import com.jjeanjacques.solidbad.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    Payment payment;

    @PostMapping("/wallet")
    public ResponseEntity<PaymentResponseDTO> wallet(@RequestBody PaymentDTO paymentDTO) {
        payment = new WalletService();
        payment.initiatePayments(paymentDTO.getItems());

        var paymentResponse = PaymentResponseDTO.builder()
                .status(payment.status())
                .items(payment.getItems())
                .build();

        return ResponseEntity.ok(paymentResponse);
    }

    @PostMapping("/loan")
    public ResponseEntity<PaymentLoanResponseDTO> loan(@RequestBody PaymentDTO paymentDTO) {
        payment = new LoanService();
        payment.initiateLoanSettlement(paymentDTO.getItems());

        var paymentResponse = PaymentLoanResponseDTO.builder()
                .status(payment.status())
                .items(payment.getItems())
                .build();

        return ResponseEntity.ok(paymentResponse);
    }
}
