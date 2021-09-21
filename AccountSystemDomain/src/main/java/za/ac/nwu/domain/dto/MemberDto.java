package za.ac.nwu.domain.dto;


import za.ac.nwu.domain.persistence.Member;

import java.io.Serializable;

public class MemberDto implements Serializable{
    private static final long serialVersionUID = 4669654747589777598L;

    private String firstName;
    private String lastName;

    public MemberDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MemberDto(Member member){
        this.setFirstName(member.getFirstName());
        this.setLastName(member.getFirstName());
    }

    //region Accessor
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    //endregion

    //region Mutator
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //endregion
}
