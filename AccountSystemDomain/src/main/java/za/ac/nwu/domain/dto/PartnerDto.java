package za.ac.nwu.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.Partner;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Partner", description = "A DTO for Reward")
public class PartnerDto implements Serializable {

    private static final long serialVersionUID = -8954717361700421623L;

    private String partnerName;

    public PartnerDto(String partnerName) {
        this.partnerName = partnerName;
    }

    public PartnerDto(Partner partner) {
        this.setPartnerName(partner.getPartnerName());
    }

    //region Accessor
    @ApiModelProperty(
            position = 1,
            value = "Partner Name",
            name = "PartnerName",
            notes = "Partner Notes",
            dataType = "java.lang.String",
            example = "CapeUnion999",
            allowEmptyValue = false,
            required = true)
    public String getPartnerName() {
        return partnerName;
    }

    //endregion

    //region Mutator

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    //endregion

}
