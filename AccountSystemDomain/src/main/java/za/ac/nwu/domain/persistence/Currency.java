package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "CURRENCY", schema = "hr")
public class Currency implements Serializable{
    private static final long serialVersionUID = 5041405714629704573L;

    public long currencyId;
    public String currencyName;
    public long milesConv;

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

    //region Accessors

    @Id
    @SequenceGenerator(name = "CURRENCY_SEQ", sequenceName = "hr.CURRENCY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCY_SEQ")
    @Column(name="CURRENCYID")
    public long getCurrencyId() {
        return currencyId;
    }

    @Column(name="CURRENCYNAME")
    public String getCurrencyName() {
        return currencyName;
    }

    @Column(name="MILESCONV")
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

