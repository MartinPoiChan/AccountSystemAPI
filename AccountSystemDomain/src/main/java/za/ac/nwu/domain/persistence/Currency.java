package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable{
    private static final long serialVersionUID = 5041405714629704573L;

    @Id
    @Column(name="CurrencyId")
    private long currencyId;

    @Column(name="CurrencyName")
    private String currencyName;

    @Column(name="MilesConv")
    private long milesConv;

    //region Accessors

    public long getCurrencyId() {
        return currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

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
