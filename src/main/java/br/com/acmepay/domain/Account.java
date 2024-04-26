package br.com.acmepay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private List<Card> cards;
    private LocalDateTime cretedAt;
    private LocalDateTime updatedAt;
    private Boolean closed;

    public void createAccount(){

    }
}
