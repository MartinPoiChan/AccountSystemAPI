package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.Currency;
import java.io.Serializable;

public class CurrencyDto implements Serializable {
    private static final long serialVersionUID = -719206115649296410L;

    private String currencyName;
    private long milesConv;

    public CurrencyDto(String currencyName, long milesConv) {
        this.currencyName = currencyName;
        this.milesConv = milesConv;
    }

    public CurrencyDto(Currency currency){
        this.setCurrencyName(currency.getCurrencyName());
        this.setMilesConv(currency.getMilesConv());
    }

    //region Accessor
    public String getCurrencyName() {
        return currencyName;
    }
    public long getMilesConv() {
        return milesConv;
    }
    //endregion

    //region Mutator
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    public void setMilesConv(long milesConv) {
        this.milesConv = milesConv;
    }
    //endregion
}
