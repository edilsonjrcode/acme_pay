package br.com.acmepay.entities;

import java.util.List;

public class Customer {

    private Long id;

    private String name;
    private String email;
    private String phone;
    private String document;

    private List<Account> accounts;

    public void create(){
        //Change the return for a type Customer
    }

}
