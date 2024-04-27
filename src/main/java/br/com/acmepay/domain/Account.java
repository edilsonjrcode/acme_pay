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

    public void createAccount(Account account){
        this.setId(account.id);
        this.setNumber(account.number);
        this.setAgency(account.agency);
        this.setBalance(account.balance);
        this.setClosed(account.closed);
        this.setCards(new ArrayList<>());
        this.setCustomer(account.customer);
        this.setCretedAt(account.cretedAt);
        this.setUpdatedAt(account.cretedAt);

    }
}
