package br.com.acmepay.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;

    private LocalDateTime dataTransaction;

    private Integer sourceAccount;

    private Integer destinationAccount;

    private BigDecimal amount;
}
