package br.com.acmepay.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDomain {

    private Long id;
    private String flag;
    private BigDecimal cardLimit;
    private AccountDomain cardAccount;

    public void create(){
        //Change the return for a Account
    };
}
