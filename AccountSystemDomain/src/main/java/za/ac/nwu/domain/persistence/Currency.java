package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable{
    private static final long serialVersionUID = 5041405714629704573L;

    private long currencyId;
    private String currencyName;
    private long milesConv;

    public Currency(long currencyId, String currencyName, long milesConv) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.milesConv = milesConv;
    }

//region Accessors

    @Id
    @Column(name="CurrencyId")
    public long getCurrencyId() {
        return currencyId;
    }

    @Column(name="CurrencyName")
    public String getCurrencyName() {
        return currencyName;
    }

    @Column(name="MilesConv")
    public long getMilesConv() {
        return milesConv;
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

