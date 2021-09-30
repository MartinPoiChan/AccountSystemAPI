package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.domain.persistence.Currency;
import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Currency", description = "A DTO for Currency")
public class CurrencyDto implements Serializable {
    private static final long serialVersionUID = -719206115649296410L;

    private long currencyId;
    private String currencyName;
    private long milesConv;

    public CurrencyDto(String currencyName, long milesConv) {
        this.currencyName = currencyName;
        this.milesConv = milesConv;
    }

    public CurrencyDto(Currency currency){
        this.setCurrencyId(currency.getCurrencyId());
        this.setCurrencyName(currency.getCurrencyName());
        this.setMilesConv(currency.getMilesConv());
    }


    //region Accessor
    @ApiModelProperty(
            position = 1,
            value = "Currency ID",
            name = "CurrencyID",
            notes = "Currency Notes",
            dataType = "java.lang.Long",
            example = "1",
            allowEmptyValue = false,
            required = true)
    public long getCurrencyId() {
        return currencyId;
    }


    @ApiModelProperty(
            position = 1,
            value = "Currency Name",
            name = "CurrencyName",
            notes = "Currency Notes",
            dataType = "java.lang.String",
            example = "NZD",
            allowEmptyValue = false,
            required = true)
    public String getCurrencyName() {
        return currencyName;
    }

    @ApiModelProperty(
            position = 2,
            value = "Currency Fiat Value",
            name = "CurrencyMiles",
            notes = "Currency Notes",
            dataType = "java.lang.Long",
            example = "150",
            allowEmptyValue = false,
            required = true)
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

    //region JsonIgnore
    @JsonIgnore
    public Currency getCurrency(){
        return new Currency(getCurrencyName(),getMilesConv());
    }

    //endregion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyDto that = (CurrencyDto) o;
        return milesConv == that.milesConv && Objects.equals(currencyName, that.currencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyName, milesConv);
    }

    @Override
    public String toString() {
    return "CurrencyDto{" +
            "Currency ID="+ currencyId+
            "Currency Name="+ currencyName+
            "Currency Miles Conversion="+milesConv+
            "}";
    }
}
