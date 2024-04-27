package br.com.acmepay.domain;

import br.com.acmepay.exceptions.BalanceToWithdrawException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean closed;
    private List<Card> cards;
    private Customer customer;
    private LocalDateTime cretedAt;
    private LocalDateTime updatedAt;

    private List<Account> accountsCreated = new ArrayList<>();

    public void create(Account account) {
        this.setId(account.id);
        this.setCretedAt(LocalDateTime.now());
        this.setUpdatedAt(null);
        this.setCustomer(createCustomer());
        this.setCards(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setNumber(account.number);
        this.setAgency(account.agency);
        this.setClosed(account.closed);
        this.accountsCreated.add(this);
    }

    public void toWithdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if(this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
        } else {
            throw new BalanceToWithdrawException("error withdraw");
        }

    }

    public void deposit(BigDecimal amount){
        this.balance.add(amount);
    }

    public void transfer(Account accountDestiny, BigDecimal amount){
        if(this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
            accountDestiny.setBalance(getBalance().add(amount));
        } else {
            throw new RuntimeException("transfer error");
        }
    }

    private Customer createCustomer(){
        var customer = new Customer();
        customer.setId(1L);
        customer.setName("Carlos Barbosa");
        customer.setEmail("carlos@gmail.com");
        customer.setDocument("03100721403");
        customer.setPhone("83991267778");
        customer.setCretedAt(LocalDateTime.now());
        customer.setUpdatedAt(null);
        customer.setAccounts(new ArrayList<>());
        return customer;
    }

}
