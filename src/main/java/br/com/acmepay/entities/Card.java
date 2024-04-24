package br.com.acmepay.entities;

import java.math.BigDecimal;

public class Card {

    private Long id;

    private String flag;

    private BigDecimal cardLimit;

    private Account cardAccount;

    public void create(){
        //Change the return for a Account
    };
}
