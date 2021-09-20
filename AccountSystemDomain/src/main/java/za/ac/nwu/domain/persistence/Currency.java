package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable{
    private static final long serialVersionUID = 5041405714629704573L;

    @Id
    private long currencyId;
    private String currencyName;
    private long milesConv;

    public Currency(long currencyId, String currencyName, long milesConv) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.milesConv = milesConv;
    }

//region Accessors

    @Column(name="MilesConv")
    public long getCurrencyId() {
        return currencyId;
    }

    @Column(name="CurrencyName")
    public String getCurrencyName() {
        return currencyName;
    }

    @Column(name="CurrencyId")
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
}
