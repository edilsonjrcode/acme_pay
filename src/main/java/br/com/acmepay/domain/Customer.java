package br.com.acmepay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
