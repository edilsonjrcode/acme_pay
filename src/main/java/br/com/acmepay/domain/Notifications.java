package br.com.acmepay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notifications {

    private Long id;

    private LocalDateTime dataTransaction;

    private Integer sourceAccount;

    private Integer destinationAccount;

    private BigDecimal amount;
}
