package com.checkpoint4.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonDto {

    private String firstname;
    private String lastname;
    private Date birthDate;
    private char gender;
    private String photoUrl;
    private int mobileNumber;
    private int phoneNumber;

}
