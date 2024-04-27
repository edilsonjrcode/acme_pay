package br.com.acmepay.application.domain.models;

import br.com.acmepay.exceptions.BalanceToWithdrawException;
import lombok.*;
;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean closed;
    private List<CardDomain> cards;
    private CustomerDomain customer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<String> transactions = new ArrayList<>();

    public void create(AccountDomain account) {
        this.setId(account.id);
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(null);
        this.setCustomer(createCustomer());
        this.setCards(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setNumber(account.number);
        this.setAgency(account.agency);
        this.setClosed(account.closed);
        addLog("Account created successfully" + LocalDateTime.now());
    }

    public void toWithdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if(checkBalance(amount)){
            this.balance.subtract(amount);
            addLog("Withdrawl made successful" + amount.toString() + ".");
        } else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
        addLog("Deposit made successful" + amount.toString());
    }

    public void transfer(AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {
        this.toWithdraw(amount);
        accountDestiny.deposit(amount);
        addLog("Transfer completed successful. From: " + this.number
                + " to " + accountDestiny.number);
    }

    public List<String> extract(){
        return transactions;
    }

    private CustomerDomain createCustomer(){
        var customer = new CustomerDomain();
        customer.setId(1L);
        customer.setName("Edilson Júnior");
        customer.setEmail("edilson@gmail.com");
        customer.setDocument("12345678911");
        customer.setPhone("83999998888");
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(null);
        customer.setAccounts(new ArrayList<>());
        return customer;
    }

    private boolean checkBalance(BigDecimal amount){
        return this.balance.compareTo(amount) >= 0;
    }

    private void addLog(String message){
        this.transactions.add(message + LocalDateTime.now());
    }

}
