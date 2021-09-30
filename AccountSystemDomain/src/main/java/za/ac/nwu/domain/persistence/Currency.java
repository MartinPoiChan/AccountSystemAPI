package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.domain.dto.CurrencyDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CURRENCY", schema = "hr")
public class Currency implements Serializable{
    private static final long serialVersionUID = 5041405714629704573L;

    public long currencyId;
    public String currencyName;
    public long milesConv;
    private Set<MemberAccount> memberAccount;

    public Currency()
    {}

    public Currency(long currencyId, String currencyName, long milesConv) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.milesConv = milesConv;
    }

    public Currency(String currencyName, long milesConv) {
        this.currencyName = currencyName;
        this.milesConv = milesConv;
    }

    public Currency(CurrencyDto currencyDto) {
        setCurrencyId(currencyDto.getCurrencyId());
        setCurrencyName(currencyDto.getCurrencyName());
        setMilesConv(currencyDto.getMilesConv());
    }

    //region Accessors

    @Id
    @SequenceGenerator(name = "CURRENCY_SEQ", sequenceName = "hr.CURRENCY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCY_SEQ")
    @Column(name="CURRENCY_ID")
    public long getCurrencyId() {
        return currencyId;
    }

    @Column(name="CURRENCY_NAME")
    public String getCurrencyName() {
        return currencyName;
    }

    @Column(name="MILES_CONV")
    public long getMilesConv() {
        return milesConv;
    }

    @OneToMany(targetEntity = MemberAccount.class, fetch = FetchType.EAGER, mappedBy = "currencyId", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<MemberAccount> getMemberAccount(){
        return memberAccount;
    }
    //endregion

    //region Mutator

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setMilesConv(long milesConv) {
        this.milesConv = milesConv;
    }

    public void setMemberAccount(Set<MemberAccount> memberAccount) {
        this.memberAccount = memberAccount;
    }

    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return currencyId == currency.currencyId && milesConv == currency.milesConv && Objects.equals(currencyName, currency.currencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyId, currencyName, milesConv);
    }
}

