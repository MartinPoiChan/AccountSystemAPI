package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.domain.dto.PartnerDto;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Table(name = "PARTNER", schema = "hr")
public class Partner implements Serializable{
    private static final long serialVersionUID = 4933211794946159713L;

    public Set<MemberAccountTransaction> memberAccountTransactions;
    public long partnerId;
    public String partnerName;

    public Partner(){

    }

    public Partner(long partnerId, String partnerName) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
    }
    public Partner(Partner partner){
        setPartnerId(partner.getPartnerId());
        setPartnerName(partner.getPartnerName());
    }

    public Partner(PartnerDto partnerDto) {
        setPartnerName(partnerDto.getPartnerName());
    }
    //region Accessor
    @Id
    @SequenceGenerator(name = "REWARD_SEQ", sequenceName = "hr.REWARD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REWARD_SEQ")
    @Column(name="PARTNER_ID")
    public long getPartnerId() {
        return partnerId;
    }

    @Column(name="PARTNER_NAME")
    public String getPartnerName() {
        return partnerName;
    }

    @OneToMany(targetEntity = MemberAccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    public Set<MemberAccountTransaction> getMemberAccountTransactions(){
        return memberAccountTransactions;
    }

    //endregion

    //region Mutator
    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public void setMemberAccountTransactions(Set<MemberAccountTransaction> memberAccountTransactions) {
        this.memberAccountTransactions = memberAccountTransactions;
    }

    //endregion
}


