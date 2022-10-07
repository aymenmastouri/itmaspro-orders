package com.itmaspro.general.domain.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itmaspro.general.domain.model.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto // extends AbstractDto
{    private String firstName;
    private String lastName;
    private CustomerStatus status;
    private String email;
    //private Date dateOfBirth;

}
