package br.com.acmepay.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<Account> accounts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<Customer> customers = new ArrayList<>();

    public void create(Customer customer){
        this.setId(customer.id);
        this.setName(customer.name);
        this.setEmail(customer.email);
        this.setPhone(customer.phone);
        this.setDocument(customer.document);
        this.setAccounts(new ArrayList<>());
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(null);
        this.customers.add(this);
    }

    public void delete(Account account){
        customers.remove(account);
    }

    public List<Customer> getAllCustomers(){
        return customers;
    }

    public void findById(Long id){

    }

    public void updateCustomer(Customer customer){

    }

    public void validEmail(){}

    public void validCpf(){}

}
