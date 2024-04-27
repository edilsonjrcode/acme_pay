package br.com.acmepay.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDomain {

    private Long id;

    private LocalDateTime dataTransaction;

    private Integer sourceAccount;

    private Integer destinationAccount;

    private BigDecimal amount;
}
