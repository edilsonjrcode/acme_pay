package br.com.acmepay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;
    private String flag;
    private BigDecimal cardLimit;
    private Account cardAccount;

    public void create(){
        //Change the return for a Account
    };
}
