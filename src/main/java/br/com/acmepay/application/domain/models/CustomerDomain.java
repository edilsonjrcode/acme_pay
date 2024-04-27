package br.com.acmepay.application.domain.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<AccountDomain> accounts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<CustomerDomain> customers = new ArrayList<>();

    public void create(CustomerDomain customer){
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

    public void delete(AccountDomain account){
        customers.remove(account);
    }

    public List<CustomerDomain> getAllCustomers(){
        return customers;
    }

    public void findById(Long id){

    }

    public void updateCustomer(CustomerDomain customer){

    }

    public void validEmail(){}

    public void validCpf(){}

}
